package code.VO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Item {
    @Getter
    String key;
    
    @Getter
    List<String> members;
}
