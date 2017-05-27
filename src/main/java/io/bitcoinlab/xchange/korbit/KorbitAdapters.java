package io.bitcoinlab.xchange.korbit;

import io.bitcoinlab.xchange.korbit.dto.marketdata.KorbitOrderBook;
import io.bitcoinlab.xchange.korbit.dto.marketdata.KorbitTicker;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class KorbitAdapters {


    /**
     * Adapts Korbit ticker to return XChange Ticker
     *
     * @param korbitTicker
     * @param currencyPair
     * @return ticker
     */
    public static Ticker adaptTicker(KorbitTicker korbitTicker, CurrencyPair currencyPair) {
        Date timestamp = korbitTicker.getTimestamp();
        BigDecimal bid = korbitTicker.getBid();
        BigDecimal ask = korbitTicker.getAsk();
        BigDecimal high = korbitTicker.getHigh();
        BigDecimal low = korbitTicker.getLow();
        BigDecimal volume = korbitTicker.getVolume();
        BigDecimal last = korbitTicker.getLast();

        return new Ticker.Builder().timestamp(timestamp).currencyPair(currencyPair).last(last).bid(bid).ask(ask).high(high).low(low).volume(volume).build();
    }


    /**
     * Adapts Korbit order book to return XChange OrderBook
     * @param korbitOrderBook
     * @param currencyPair
     * @return order book
     */
    public static OrderBook adaptOrderBook(KorbitOrderBook korbitOrderBook, CurrencyPair currencyPair) {
        Date timestamp = korbitOrderBook.getTimestamp();
        OrderBook orderBook = new OrderBook(
                timestamp,
                transformArrayToLimitOrders(korbitOrderBook.getAsks(),
                        Order.OrderType.ASK, currencyPair, timestamp),
                transformArrayToLimitOrders(korbitOrderBook.getBids(),
                        Order.OrderType.BID, currencyPair, timestamp));

        return orderBook;
    }


    private static List<LimitOrder> transformArrayToLimitOrders(BigDecimal[][] orders, Order.OrderType orderType,
                                                                CurrencyPair currencyPair, Date timestamp) {
        List<LimitOrder> limitOrders = new ArrayList<>();
        for (BigDecimal[] order : orders) {
            limitOrders.add(new LimitOrder(orderType, order[1], currencyPair, null, timestamp, order[0]));
        }

        return limitOrders;
    }
}
