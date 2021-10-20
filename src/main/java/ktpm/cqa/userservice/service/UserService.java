package ktpm.cqa.userservice.service;

import ktpm.cqa.userservice.VO.Department;
import ktpm.cqa.userservice.VO.ResponseTemplateVO;
import ktpm.cqa.userservice.entity.User;
import ktpm.cqa.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepository.saveAndFlush(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();
        vo.setUser(user);
        Department department = restTemplate.getForObject("http://localhost:8081/deparments/" + user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        return vo;
    }
}
