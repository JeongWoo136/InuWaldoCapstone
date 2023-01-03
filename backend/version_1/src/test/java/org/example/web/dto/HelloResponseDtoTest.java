package org.example.web.dto;

import org.example.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name ="test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount); // 생성자로 생성

        //then
        assertThat(dto.getName()).isEqualTo(name); //getter 검증
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
