package io.bitcoinlab.xchange.korbit;

import io.bitcoinlab.xchange.korbit.service.KorbitDataService;
import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.utils.nonce.CurrentTime1000NonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;

/**
 *
 */
public class KorbitExchange extends BaseExchange implements Exchange {

    private SynchronizedValueFactory<Long> nonceFactory = new CurrentTime1000NonceFactory();

    @Override
    protected void initServices() {
        this.marketDataService = new KorbitDataService(this);
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {

        ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
        exchangeSpecification.setSslUri("https://api.korbit.co.kr");
        exchangeSpecification.setHost("api.korbit.co.kr");
        exchangeSpecification.setPort(443);
        exchangeSpecification.setExchangeName("Korbit");
        exchangeSpecification.setExchangeDescription("Korbit is a Bitcoin-Korean Won exchange.");

        return exchangeSpecification;
    }

    @Override
    public SynchronizedValueFactory<Long> getNonceFactory() {

        return nonceFactory;
    }
}

