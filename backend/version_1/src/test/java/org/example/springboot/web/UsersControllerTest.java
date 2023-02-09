package org.example.springboot.web;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)//Junit에 내장된 실행자 외에 다른 실행자 실행. 스프링부트테스트와 Junit을 연결해준다.
@WebMvcTest(controllers = UsersController.class) //스프링 어노테이션 중 Web에 집중할 수 있는 어노테이션
public class UsersControllerTest extends TestCase {
    @Autowired
    private MockMvc mvc; //웹 api테스트용 ,mvc테스트의 시작점. get,post등을 테스트할 수 있다

    @Test
    public void users리턴() throws Exception{
        String users ="users";
        mvc.perform(get("/users")) // /hello주소로 get요청
                .andExpect(status().isOk()) //결과를 검증. 200 = ok
                .andExpect(content().string(users));//응답 본문의 내용을 검증
    }
    @Test
    public void 회원가입테스트() throws Exception{
        String userId="thomas123";
        String password="abcd";
        String name="thomas";
        double drivingScore=98.2;
        int mileage=200;
        mvc.perform(
                        get("/users/join")
                                .param("userId",userId)
                                .param("password",password)
                                .param("name",name) //테스트시 사용할 파라미터를 설정 (Sring만 가능)
                                .param("drivingScore",String.valueOf(drivingScore))
                                .param("mileage",
                                        String.valueOf(mileage))

                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId",is(userId)))
                .andExpect(jsonPath("$.password",is(password)))
                .andExpect(jsonPath("$.name",is(name))) //json응답 값을 필드별로 검증하는 메소드
                .andExpect(jsonPath("$.drivingScore",is(drivingScore)))
                .andExpect(jsonPath("$.mileage",is(mileage)));

    }

}