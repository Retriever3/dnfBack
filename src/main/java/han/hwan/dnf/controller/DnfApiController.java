// DnfApiController.java
package han.hwan.dnf.controller;

import han.hwan.dnf.service.DnfApiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DnfApiController {

    private final DnfApiService dnfApiService;

    // 생성자 주입
    public DnfApiController(DnfApiService dnfApiService) {
        this.dnfApiService = dnfApiService;
    }
    
    //서버 정보
    @CrossOrigin(origins = "http://localhost:3000") // 클라이언트의 주소에 맞게 변경
    @GetMapping("/api/servers")
    public Object getServerList() {
        return dnfApiService.getServerList();
    }
    
    //캐릭터 검색
    @GetMapping("/api/searchCharacter")
    public Object searchCharacter(
    		//파라미터 이름을 명시
    		@RequestParam(name = "serverId") String serverId,
            @RequestParam(name = "characterName") String characterName
    ) {
        return dnfApiService.searchCharacter(serverId, characterName);
    }
    
    //캐릭터 기본 정보 조회
    @GetMapping("/api/baseInfo")
    public Object getBaseInfo(
    		//파라미터 이름을 명시
    		@RequestParam(name = "serverId") String serverId,
            @RequestParam(name = "characterId") String characterId
    ) {
        return dnfApiService.getBaseInfo(serverId, characterId);
    }
    
    //캐릭터 능력치 정보 조회
    @GetMapping("/api/status")
    public Object getStatusInfo(
        @RequestParam(name = "serverId") String serverId,
        @RequestParam(name = "characterId") String characterId
    ) {
        return dnfApiService.getStatusInfo(serverId, characterId);
    }
    
    //장착 장비 죠회
    @GetMapping("/api/equip")
    public Object getEquipInfo(
        @RequestParam(name = "serverId") String serverId,
        @RequestParam(name = "characterId") String characterId
    ) {
        return dnfApiService.getEquipInfo(serverId, characterId);
    }
    
    //직업 정보
    @CrossOrigin(origins = "http://localhost:3000") // 클라이언트의 주소에 맞게 변경
    @GetMapping("/api/jobs")
    public Object getJobsList() {
        return dnfApiService.getJobsList();
    }
    
    // 타임 라인
//    @CrossOrigin(origins = "http://localhost:3000") // 클라이언트의 주소에 맞게 변경
//    @GetMapping("/api/timeLine")
//    public Object getTimeLine(
//    		@RequestParam String serverId,
//            @RequestParam String characterId,
//            @RequestParam int limit,
//            @RequestParam String code,
//            @RequestParam String startDate,
//            @RequestParam String endDate,
//            @RequestParam String next
//    		) {
//        return dnfApiService.getTimeLine();
//    }
}

