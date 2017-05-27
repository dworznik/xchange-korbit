package io.bitcoinlab.xchange.korbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KorbitOrderBook {

    private final Date timestamp;

    private final BigDecimal[][] asks;

    private final BigDecimal[][] bids;


    /**
     * Constructor
     *
     * @param timestamp
     * @param asks
     * @param bids
     */
    public KorbitOrderBook(@JsonProperty("timestamp") Date timestamp, @JsonProperty("asks") BigDecimal[][] asks, @JsonProperty("bids") BigDecimal[][] bids) {
        this.timestamp = timestamp;
        this.asks = asks;
        this.bids = bids;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public BigDecimal[][] getAsks() {
        return asks;
    }

    public BigDecimal[][] getBids() {
        return bids;
    }

    @Override
    public String toString() {

        StringBuilder asksBuilder = new StringBuilder();
        StringBuilder bidsBuilder = new StringBuilder();

        for (BigDecimal[] ask : getAsks()) {
            asksBuilder.append(Arrays.toString(ask) + ";");
        }
        for (BigDecimal[] bid : getBids()) {
            bidsBuilder.append(Arrays.toString(bid) + ";");
        }

        return "KorbitOrderBook{" + "timestamp=" + timestamp + "asks=" + asksBuilder + ", bids=" + bidsBuilder + "}";
    }

}
