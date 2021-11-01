package ktpm.cqa.userservice.service;

import ktpm.cqa.userservice.VO.Department;
import ktpm.cqa.userservice.VO.UserVO;
import ktpm.cqa.userservice.entity.User;
import ktpm.cqa.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.department}")
    private String departmentUrl;

    public User saveUser(User user){
        return userRepository.saveAndFlush(user);
    }

    public UserVO getUserWithDepartment(Long userId){
        UserVO userVO = new UserVO();
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject(departmentUrl + user.getDepartmentId(), Department.class);
        userVO.setUser(user);
        userVO.setDepartment(department);
        return userVO;
    }
}
