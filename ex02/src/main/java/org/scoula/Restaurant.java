package org.scoula;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Setter;


@Component
@Data //기본생성장+getter+setter
@RequiredArgsConstructor

public class Restaurant {
//   chef가 빈으로 등록되어 있어야함
//    @Autowired  //외부에서 의존성 주입해서 자동 연결하겠다
   final private Chef chef;
}
