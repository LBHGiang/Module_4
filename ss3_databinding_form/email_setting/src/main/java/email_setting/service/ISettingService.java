package email_setting.service;

import email_setting.model.Setting;

import java.util.List;

public interface ISettingService {

    Setting getSetting();

    List<String> getLanguages();

    List<Integer> getPageSizes();

    void updateSetting(Setting setting);
}
