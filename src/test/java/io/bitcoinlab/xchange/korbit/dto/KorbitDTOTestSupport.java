package io.bitcoinlab.xchange.korbit.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class KorbitDTOTestSupport {

    private static ObjectMapper mapper = new ObjectMapper();

    protected <E> E parse(String filename, Class<E> type) throws IOException {
        InputStream is = getStream(filename);
        return mapper.readValue(is, type);
    }

    protected InputStream getStream(String filename) {
        return KorbitDTOTestSupport.class.getResourceAsStream(filename);
    }

}
