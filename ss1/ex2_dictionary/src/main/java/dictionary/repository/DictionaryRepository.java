package dictionary.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private final String[] english = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    private final String[] vietnamese = {"một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín", "mười"};

    @Override
    public String search(String word) {
        int index = -1;
        for (int i = 0; i < english.length; i++) {
            if (english[i].equals(word)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "Không có trong từ điển";
        }
        return vietnamese[index];
    }
}
