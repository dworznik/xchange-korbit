package io.bitcoinlab.xchange.korbit.service;

import io.bitcoinlab.xchange.korbit.Korbit;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import si.mazi.rescu.RestProxyFactory;

/**
 * `
 */
public class KorbitBaseService extends BaseExchangeService implements BaseService {

    protected final Korbit korbit;

    /**
     * Constructor
     *
     * @param exchange
     */
    protected KorbitBaseService(Exchange exchange) {
        super(exchange);

        korbit = RestProxyFactory.createProxy(Korbit.class, exchange.getExchangeSpecification().getSslUri());
    }
}
