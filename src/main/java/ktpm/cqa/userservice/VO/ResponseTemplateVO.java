package ktpm.cqa.userservice.VO;

import ktpm.cqa.userservice.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
