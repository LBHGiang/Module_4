package email_setting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import email_setting.model.Setting;
import email_setting.repository.ISettingRepository;

import java.util.List;

@Service
public class SettingService implements ISettingService {
    @Autowired
    private ISettingRepository settingRepository;


    @Override
    public Setting getSetting() {
        return settingRepository.getSetting();
    }

    @Override
    public List<String> getLanguages() {
        return settingRepository.getLanguages();
    }

    @Override
    public List<Integer> getPageSizes() {
        return settingRepository.getPageSizes();
    }

    @Override
    public void updateSetting(Setting setting) {
        settingRepository.updateSetting(setting);
    }
}
