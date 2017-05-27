package io.bitcoinlab.xchange.korbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class KorbitTicker {

    private final Date timestamp;
    private final BigDecimal ask;
    private final BigDecimal bid;
    private final BigDecimal last;
    private final BigDecimal low;
    private final BigDecimal high;
    private final BigDecimal volume;


    /**
     * Constructor
     *
     * @param timestamp
     * @param ask
     * @param bid
     * @param last
     * @param low
     * @param high
     * @param volume
     */
    public KorbitTicker(@JsonProperty("timestamp") Date timestamp, @JsonProperty("ask") BigDecimal ask, @JsonProperty("bid") BigDecimal bid, @JsonProperty("last") BigDecimal last,
                        @JsonProperty("low") BigDecimal low, @JsonProperty("high") BigDecimal high, @JsonProperty("volume") BigDecimal volume) {

        this.timestamp = timestamp;
        this.ask = ask;
        this.bid = bid;
        this.last = last;
        this.low = low;
        this.high = high;
        this.volume = volume;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getLast() {
        return last;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "KorbitTicker{" + "timestamp=" + timestamp + "ask=" + ask + ", bid=" + bid + ", last=" + last + ", low=" + low + ", high=" + high + ", volume="
                + volume + "}";
    }
}
