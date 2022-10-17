package email_setting.repository;

import org.springframework.stereotype.Repository;
import email_setting.model.Setting;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingRepository implements ISettingRepository {

    private Setting setting = new Setting();
    private final static List<String> languages;

    static {
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Chinese");
        languages.add("Japanese");
    }

    private final static List<Integer> pageSize;

    static {
        pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }


    @Override
    public Setting getSetting() {
        return setting;
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getPageSizes() {
        return pageSize;
    }

    @Override
    public void updateSetting(Setting newSetting) {
        setting = newSetting;
    }
}
