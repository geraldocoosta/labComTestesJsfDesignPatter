package br.com.ultcode.argentum.xstream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateTimeConverter implements Converter {

    @SuppressWarnings("unchecked")
    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
	return type.isAssignableFrom(LocalDateTime.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
	LocalDateTime time = (LocalDateTime) source;
	ZonedDateTime dataComZona = time.atZone(ZoneOffset.systemDefault());
	long millis = dataComZona.toInstant().toEpochMilli();

	writer.startNode("time");
	writer.setValue(String.valueOf(millis));
	writer.endNode();

	writer.startNode("timezone");
	writer.setValue(dataComZona.getZone().toString());
	writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
	reader.moveDown();
	String time = reader.getValue();
	reader.moveUp();

	reader.moveDown();
	String timezone = reader.getValue();
	reader.moveUp();

	long tempoEmMillis = Long.parseLong(time);
	Instant instante = Instant.ofEpochMilli(tempoEmMillis);
	ZoneId zona = ZoneId.of(timezone);
	ZonedDateTime dataComZone = ZonedDateTime.ofInstant(instante, zona);
	LocalDateTime data = dataComZone.toLocalDateTime();

	return data;
    }

}
