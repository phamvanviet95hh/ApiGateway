package com.apigateway.apigateway.services;

import com.apigateway.apigateway.dtos.StaffDto;
import com.apigateway.apigateway.dtos.requests.LoginRequest;
import com.apigateway.apigateway.dtos.response.LoginResponse;
import com.apigateway.apigateway.dtos.response.StaffRespon;
import com.apigateway.apigateway.models.StaffModel;
import com.apigateway.apigateway.repositorys.StaffRepository;
import com.apigateway.apigateway.utlis.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private UserDetailSever userDetailSever;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;
    private Boolean success = false;
    private String message = null;
    private String jwt =null;
    private int status = 0;

    public int createStaff(StaffDto staffDto){
        try {
            StaffModel model = StaffModel.builder()
                    .id(UUID.randomUUID().toString())
                    .nameStaff(staffDto.getNameStaff())
                    .email(staffDto.getEmail())
                    .password(new BCryptPasswordEncoder().encode(staffDto.getPassword()))
                    .oldStaff(staffDto.getOldStaff())
                    .addressStaff(staffDto.getAddressStaff())
                    .createAt(staffDto.getCreateAt())
                    .updateAt(staffDto.getUpdateAt())
                    .deleteAt(staffDto.getDeleteAt())
                    .build();
            staffRepository.save(model);
            status=1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }


    public boolean checkPassword(StaffModel staffModel, String rawPassword) {
        return passwordEncoder.matches(rawPassword, staffModel.getPassword());
    }
    public LoginResponse login(LoginRequest username){
        StaffModel staffModel;
        StaffRespon staffRespon = null;
        try{
            staffModel = staffRepository.findByEmail(username.getEmail());
            System.out.println(staffModel);
            if (staffModel == null || !checkPassword(staffModel, username.getPassword())) {
                throw new Exception("Invalid username or password");
            }
            success = true;
            UserDetails userDetails = userDetailSever.loadUserByUsername(username.getEmail());
            jwt = jwtUtil.generateToken(userDetails.getUsername());
            message = "Login SuccessFull !!!";
            staffRespon = new StaffRespon(staffModel.getId(), staffModel.getNameStaff(), staffModel.getEmail(), staffModel.getOldStaff(), staffModel.getAddressStaff());
        }catch (Exception e){
            message = "Login Fail!!!";
            e.printStackTrace();
        }
        return new LoginResponse(success, message, jwt , staffRespon);
    }


}
