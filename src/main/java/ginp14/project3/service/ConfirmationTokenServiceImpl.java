package ginp14.project3.service;

import ginp14.project3.dao.ConfirmationTokenRepository;
import ginp14.project3.model.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public void save(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return confirmationTokenRepository.findByConfirmationToken(confirmationToken);
    }
}
