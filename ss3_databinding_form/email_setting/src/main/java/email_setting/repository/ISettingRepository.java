package email_setting.repository;

import email_setting.model.Setting;

import java.util.List;

public interface ISettingRepository {

    Setting getSetting();

    List<String> getLanguages();

    List<Integer> getPageSizes();

    void updateSetting(Setting setting);

}
