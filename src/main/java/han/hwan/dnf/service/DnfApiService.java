package han.hwan.dnf.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DnfApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "vDeslmMyAWEVlUblpPaO7sJzJszIKUU9";
    
    //서버 정보
    public Object getServerList() {
        String url = "https://api.neople.co.kr/df/servers?apikey=" + apiKey;
        return restTemplate.getForObject(url, Object.class);
    }
    
    //캐릭터 검색
    public Object searchCharacter(String serverId, String characterName) {
        String url = "https://api.neople.co.kr/df/servers/" + serverId + "/characters?characterName=" + characterName + "&apikey=" + apiKey;
        return restTemplate.getForObject(url, Object.class);
    }
    
    // 캐릭터 기본 정보 조회
    public Object getBaseInfo(String serverId, String characterId) {
        String url = "https://api.neople.co.kr/df/servers/" + serverId + "/characters/" + characterId + "?apikey=" + apiKey;
       
        return restTemplate.getForObject(url, Object.class);
    }

    // 캐릭터 능력치 조회
    public Object getStatusInfo(String serverId, String characterId) {
        String url = "https://api.neople.co.kr/df/servers/" + serverId + "/characters/" + characterId + "/status?apikey=" + apiKey;

        return restTemplate.getForObject(url, Object.class);
    }
    
    // 캐릭터 장착 장비 죠회
    public Object getEquipInfo(String serverId, String characterId) {
        String url = "https://api.neople.co.kr/df/servers/" + serverId + "/characters/" + characterId + "/equip/equipment?apikey=" + apiKey;
        System.out.println(url);
        return restTemplate.getForObject(url, Object.class);
    }
    
    //직업 정보
    public Object getJobsList() {
        String url = "https://api.neople.co.kr/df/jobs?apikey=" + apiKey;
        return restTemplate.getForObject(url, Object.class);
    }
    
 // 캐릭터 능력치 조회
    public Object getTimeLine(String serverId, String characterId) {
        String url = "https://api.neople.co.kr/df/servers/" + serverId + "/characters/" + characterId + "/timeline?apikey=" + apiKey;

        return restTemplate.getForObject(url, Object.class);
    }

}
