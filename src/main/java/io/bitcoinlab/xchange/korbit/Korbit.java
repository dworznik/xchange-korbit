package io.bitcoinlab.xchange.korbit;

import io.bitcoinlab.xchange.korbit.dto.marketdata.KorbitOrderBook;
import io.bitcoinlab.xchange.korbit.dto.marketdata.KorbitTicker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;


@Path("v1")
@Produces(MediaType.APPLICATION_JSON)
public interface Korbit {

    /**
     *
     * @param currency
     * @return Korbit ticker
     * @throws IOException
     */
    @GET
    @Path("ticker/detailed?currency_pair={currencyPair}")
    KorbitTicker getTicker(@PathParam("currencyPair") String currency) throws IOException;

    /**
     *
     * @param currency
     * @return Korbit order book
     * @throws IOException
     */
    @GET
    @Path("orderbook?currency_pair={currencyPair}")
    KorbitOrderBook getOrderBook(@PathParam("currencyPair") String currency) throws IOException;

}
