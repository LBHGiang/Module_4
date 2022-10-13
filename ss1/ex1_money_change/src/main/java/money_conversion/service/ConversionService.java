package money_conversion.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionService implements IConversionService {

    @Override
    public double change(String usd, String rate) {
        return Double.parseDouble(usd) * Double.parseDouble(rate);
    }
}
