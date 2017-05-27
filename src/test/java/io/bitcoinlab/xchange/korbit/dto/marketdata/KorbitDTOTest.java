package io.bitcoinlab.xchange.korbit.dto.marketdata;

import io.bitcoinlab.xchange.korbit.dto.KorbitDTOTestSupport;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 *
 */
public class KorbitDTOTest extends KorbitDTOTestSupport {


    @Test
    public void shouldParseTicker() throws IOException {
        // when
        KorbitTicker response = parse("/marketdata/example-ticker-data.json", KorbitTicker.class);

        KorbitTicker ticker = new KorbitTicker(new Date(1495890492000L), new BigDecimal("2767500"), new BigDecimal("2766500"),
                new BigDecimal("2766000"), new BigDecimal("2510000"), new BigDecimal("3759500"),
                new BigDecimal("13640.47932234"));

        assertThat(response.getTimestamp()).isEqualTo(ticker.getTimestamp());
        assertThat(response.getAsk()).isEqualTo(ticker.getAsk());
        assertThat(response.getBid()).isEqualTo(ticker.getBid());
        assertThat(response.getLast()).isEqualTo(ticker.getLast());
        assertThat(response.getLow()).isEqualTo(ticker.getLow());
        assertThat(response.getHigh()).isEqualTo(ticker.getHigh());
        assertThat(response.getVolume()).isEqualTo(ticker.getVolume());
        assertThat(response.toString()).isEqualTo(ticker.toString());
    }

    @Test
    public void shouldParseOrderBook() throws Exception {

        KorbitOrderBook response = parse("/marketdata/example-orderbook-data.json", KorbitOrderBook.class);

        BigDecimal[][] bids = {
                {new BigDecimal("2766500"), new BigDecimal("4.15318094"), new BigDecimal("4.15318094")},
                {new BigDecimal("4.15318094"), new BigDecimal("11.31098301"), new BigDecimal("1")}
        };

        BigDecimal[][] asks = {
                {new BigDecimal("2767000"), new BigDecimal("0.00500000"), new BigDecimal("1")},
                {new BigDecimal("2767500"), new BigDecimal("1.85344246"), new BigDecimal("1")}
        };

        assertThat(response.getTimestamp()).isEqualTo(new Date(1495890465000L));
        assertThat(response.getAsks()).isEqualTo(asks);
        assertThat(response.getBids()).isEqualTo(bids);
    }
}
