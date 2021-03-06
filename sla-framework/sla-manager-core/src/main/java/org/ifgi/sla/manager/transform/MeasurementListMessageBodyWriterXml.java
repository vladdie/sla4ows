package org.ifgi.sla.manager.transform;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.ifgi.namespaces.wsag.rest.MeasurementListDocument;
import org.ifgi.namespaces.wsag.rest.impl.MeasurementListDocumentImpl;

import com.sun.jersey.spi.resource.Singleton;

@Provider
@Singleton
public class MeasurementListMessageBodyWriterXml implements MessageBodyWriter<MeasurementListDocument>
{
	protected static Logger LOGGER = Logger.getLogger(MeasurementListMessageBodyWriterXml.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.MessageBodyWriter#getSize(java.lang.Object, java.lang.Class, java.lang.reflect.Type, java.lang.annotation.Annotation[],
	 * javax.ws.rs.core.MediaType)
	 */
	@Override
	public long getSize(MeasurementListDocument arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4)
	{
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.MessageBodyWriter#isWriteable(java.lang.Class, java.lang.reflect.Type, java.lang.annotation.Annotation[],
	 * javax.ws.rs.core.MediaType)
	 */
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		boolean mediaTypeCompatible = mediaType.isCompatible(MediaType.APPLICATION_XML_TYPE) || mediaType.isCompatible(MediaType.TEXT_XML_TYPE);
		boolean classTypeCompatibel = type.getName().equalsIgnoreCase(MeasurementListDocumentImpl.class.getName());
		return (mediaTypeCompatible && classTypeCompatibel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.MessageBodyWriter#writeTo(java.lang.Object, java.lang.Class, java.lang.reflect.Type, java.lang.annotation.Annotation[],
	 * javax.ws.rs.core.MediaType, javax.ws.rs.core.MultivaluedMap, java.io.OutputStream)
	 */
	@Override
	public void writeTo(MeasurementListDocument t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException
	{
		Writer writer = new OutputStreamWriter(entityStream);
		writer.write(t.xmlText());
		writer.close();
	}
}
