-- --------------------------------------------------------
-- 호스트:                          183.111.138.245
-- 서버 버전:                        10.1.13-MariaDB - MariaDB Server
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- dbrjsdml 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `dbrjsdml` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbrjsdml`;

-- 테이블 dbrjsdml.youtubeChannelIndex 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeChannelIndex` (
  `idx` int(11) NOT NULL,
  `c_info` varchar(100) NOT NULL,
  `c_email` varchar(100) NOT NULL,
  `c_location` varchar(100) NOT NULL,
  `c_link` varchar(100) NOT NULL,
  `c_day` varchar(100) NOT NULL,
  `c_view` varchar(100) NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeChannelIndex:~8 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeChannelIndex` DISABLE KEYS */;
INSERT INTO `youtubeChannelIndex` (`idx`, `c_info`, `c_email`, `c_location`, `c_link`, `c_day`, `c_view`) VALUES
	(3, 'I make football videos.', 'nuoctta48@gmail.com', '대한민국', 'https://www.youtube.com/@user-xj1lc5kc6f/featured', '2020. 2. 2.', '4,258,464회'),
	(4, '소셜 모바일 세대를 위한 딩고 Dingo의 대표 음악채널 딩고 뮤직(Dingo Music).', 'musicbiz@makeus.com', '대한민국', 'https://www.youtube.com/@DingoMusic/featured', '2015. 2. 11.', '1,783,986,235회'),
	(5, '게임 스토리 전문 채널, "GCL 지씨엘" 입니다!', 'gamp@bigpi.co', '대한민국', 'https://www.youtube.com/@GCL', '2015. 3. 20.', '300,308,414회'),
	(6, 'Now music is a big part of my life.', 'post@mer.as', '노르웨이', 'https://www.youtube.com/channel/UCJrOtniJ0-NWz37R30urifQ', '2012. 8. 26.', '12,369,369,097회'),
	(7, 'Hello, all animal lovers!\r\nⓒSBS. Corp ALL RIGHTS RESERVED', 'sbsyang11@gmail.com', '대한민국', 'https://www.youtube.com/@SBSANIMAL', '2015. 9. 3.', '4,575,016,722회'),
	(8, '페이커의 공식 유튜브 채널입니다. 구독과 좋아요로 페이커 선수를 응원해주세요.', 'T1Faker@gmail.com', '대한민국', 'https://www.youtube.com/channel/UCpJw2H9KKqwCCGQKRh1Bf2w', '2017. 2. 9.', '354,127,607회'),
	(9, '반갑습니다. 오늘도 즐거운 날입니다.', 'calmdownman@sandboxnetwork.net', '대한민국', 'https://www.youtube.com/@calmdownman_official', '2014. 9. 30.', '1,528,286,248회'),
	(10, '코미디 인재 육성 및 연구의 메카 피식대학\r\n멤버\r\n이용주\r\n정재형\r\n김민수', 'psickuniv@metacomedy.net', '대한민국', 'https://www.youtube.com/@PsickUniv', '2019. 4. 1.', '724,487,487회');
/*!40000 ALTER TABLE `youtubeChannelIndex` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeChannelList 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeChannelList` (
  `idx` int(11) NOT NULL,
  `ch_name` varchar(40) NOT NULL,
  `ch_id` varchar(40) NOT NULL,
  `ch_follow` varchar(40) NOT NULL,
  `writer` varchar(40) NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeChannelList:~8 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeChannelList` DISABLE KEYS */;
INSERT INTO `youtubeChannelList` (`idx`, `ch_name`, `ch_id`, `ch_follow`, `writer`) VALUES
	(3, 'mtlt1996 official', '@user-vl7cg2lp4b', '구독자 1.17천명', 'mtit1996'),
	(4, '딩고 뮤직 / dingo music', '@DingoMusic', '구독자 423만명', '딩고뮤직'),
	(5, 'GCL 지씨엘', '@GCL', '구독자 93만명', 'GCL 지씨엘'),
	(6, 'Alan Walker', '@Alan Walker', '구독자 4290만명', 'Alan Walker'),
	(7, 'SBS TV동물농장x애니멀봐 공식 유튜브 채널입니다! ', '@SBSANIMAL', '구독자 480만명\r\n', '애니멀봐'),
	(8, 'T1 Faker', '@T1_Faker', '구독자 167만명', 'T1Faker'),
	(9, '침착맨', '@calmdownman_official', '구독자 206만명', '침착맨'),
	(10, '피식대학Psick Univ', '@PsickUniv', '구독자 187만명', '피식대학');
/*!40000 ALTER TABLE `youtubeChannelList` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeFollowList 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeFollowList` (
  `user_idx` int(11) NOT NULL,
  `idx` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeFollowList:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeFollowList` DISABLE KEYS */;
INSERT INTO `youtubeFollowList` (`user_idx`, `idx`) VALUES
	(3, 7),
	(3, 9),
	(3, 8),
	(9, 9);
/*!40000 ALTER TABLE `youtubeFollowList` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeList 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeList` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(300) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `readcount` int(11) NOT NULL,
  `thum` varchar(100) NOT NULL,
  `url` varchar(500) NOT NULL,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeList:~80 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeList` DISABLE KEYS */;
INSERT INTO `youtubeList` (`idx`, `subject`, `writer`, `readcount`, `thum`, `url`, `category`) VALUES
	(1, '[한글자막] 윤도현에게 2002 월드컵 수익을 묻다', '피식대학', 122385, './image/icon10.jpg', 'https://www.youtube.com/embed/rGa2r9uPtUg', 2),
	(2, '[05학번이즈히어] 신도시 고깃집 여사장은 어떻게 일하는가', '피식대학', 195843, './image/icon10.jpg', 'https://www.youtube.com/embed/1Hu2sHhsSPI', 2),
	(3, '[한글자막] 립제이에게 쿨제이를 묻다', '피식대학', 103820, './image/icon10.jpg', 'https://www.youtube.com/embed/yU_Gx7Ncs9s', 2),
	(4, '[05학번이즈히어] 신도시 카페 사장은 어떻게 사는가', '피식대학', 165796, './image/icon10.jpg', 'https://www.youtube.com/embed/NsRPxHC84qw', 2),
	(5, '아바타: 물의 길 오디션 지원 영상 (배우 정재형);', '피식대학', 9038, './image/icon10.jpg', 'https://www.youtube.com/embed/iahwr75Wfc4', 2),
	(6, '[한글자막] 박재범에게 원소주 원가를 묻다', '피식대학', 19969, './image/icon10.jpg', 'https://www.youtube.com/embed/qW8pEIocLkU', 2),
	(7, '(161224); 길은지♥️조정구 예비부부 가편집본2 (신랑 전달용);', '피식대학', 48429, './image/icon10.jpg', 'https://www.youtube.com/embed/9NoBGXrc5RY', 2),
	(8, '[한글자막] 카모에게 전화번호를 묻다', '피식대학', 69531, './image/icon10.jpg', 'https://www.youtube.com/embed/fKaBhqrlXdY', 2),
	(9, '도요다 부장님이 계약 성공 후 꼭 들르는 힐링 맛집?!', '피식대학', 1147539, './image/icon10.jpg', 'https://www.youtube.com/embed/YndDkf7yVPk', 2),
	(10, '[05학번이즈히어] 신도시 부부는 결혼기념일에 무엇을 하는가', '피식대학', 87085, './image/icon10.jpg', 'https://www.youtube.com/embed/yuNQheV5Zsk', 2),
	(11, '환타로 만든 뱅쇼 vs 쌍화탕으로 만든 모주', '침착맨', 21133, './image/icon9.jpg', 'https://www.youtube.com/embed/0pw5gBIAWQM?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(12, '2021년은 어땠나? 2022년은 어떨까?', '침착맨', 81724, './image/icon9.jpg', 'https://www.youtube.com/embed/rwYoIzl5o9U?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(13, '치킨계의 냉전시대', '침착맨', 64063, './image/icon9.jpg', 'https://www.youtube.com/embed/-YZ_z_TRBnY?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(14, '90년대 애니 여캐 둘러보기', '침착맨', 73785, './image/icon9.jpg', 'https://www.youtube.com/embed/IcTjuJGoPbQ?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(15, '저가요 거위인데요', '침착맨', 170893, './image/icon9.jpg', 'https://www.youtube.com/embed/bDKA_p8jhSw?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(16, '꽁치가처넌의 멸망의 노래!', '침착맨', 70087, './image/icon9.jpg', 'https://www.youtube.com/embed/qMc79yi2N4A?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(17, '침착맨과 인기웹툰 \'나 혼자만 레벨업\' 같이 보기', '침착맨', 1851068, './image/icon9.jpg', 'https://www.youtube.com/embed/Z__KMr6QLEQ?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(18, '맞기 싫은 몽둥이 월드컵', '침착맨', 21779, './image/icon9.jpg', 'https://www.youtube.com/embed/V0pNWjWlazo?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(19, '새해 금연합니다, 현상금 1000만원', '침착맨', 64012, './image/icon9.jpg', 'https://www.youtube.com/embed/yJI9iCKlD9A?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(20, '특이한 벌레와 새 이야기', '침착맨', 68643, './image/icon9.jpg', 'https://www.youtube.com/embed/5T_4pnS6nxA?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(21, '그 시절 우리가 사랑했던 쪼꼬미 동물병원 1~12화 모아보기ㅣBinge-Watch On Animal Hospital For Tiny Animals', '애니멀봐', 108766, './image/icon7.jpg', 'https://www.youtube.com/embed/nNh9bO5xdso', 3),
	(22, '쪼꼬미와 한 시간의 행방불명 쪼꼬미 동물병원2 1~12화 모아보기ㅣBinge-Watch On Animal Hospital For Tiny Animals 2', '애니멀봐', 42777, './image/icon7.jpg', 'https://www.youtube.com/embed/pHNaSDoDFLQ', 3),
	(23, '추석 연휴 종료 기념 (나 우냐..) 나새끼 종합 선물 셋뚜셋뚜ㅣI’m THE Baby Compilation Gift Box', '애니멀봐', 216591, './image/icon7.jpg', 'https://www.youtube.com/embed/zwgJSbTo884', 3),
	(24, '쪼꼬미 동물병원 8화 (내원환자 : 드워프햄스터 두부님)ㅣAnimal Hospital for Tiny Animals Ep 8 (Patient: Dubu, Dwarf Hamster)', '애니멀봐', 113087, './image/icon7.jpg', 'https://www.youtube.com/embed/nLzPsYyVD6w', 3),
	(25, '쪼꼬미 동물병원 시즌2 1화 (내원환자 : 드워프햄스터 두부님)ㅣAnimal Hospital for Tiny Animals2 Ep 1(Patient: Dubu, Hamster)', '애니멀봐', 113577, './image/icon7.jpg', 'https://www.youtube.com/embed/DXeroPf0MFs', 3),
	(26, '쪼꼬미 동물병원 시즌2 11화 (내원환자: 라쿤 설기님)ㅣAnimal Hospital for Tiny Animals2 Ep 11 (Patient: Seolgi, Raccoon)', '애니멀봐', 92902, './image/icon7.jpg', 'https://www.youtube.com/embed/SXMkDjlLp8Q', 3),
	(27, '쪼꼬미 동물병원 시즌2 6화 (내원환자: 푸딩 햄스터 밍키님)', '애니멀봐', 34108, './image/icon7.jpg', 'https://www.youtube.com/embed/JiDghYNKYL8', 3),
	(28, '쪼꼬미 동물병원 2화 (내원환자 : 미어캣 순둥이님)ㅣReason Why A Cheerful Meerkat Came To The Animal Hospital', '애니멀봐', 135989, './image/icon7.jpg', 'https://www.youtube.com/embed/xDOlKAFpAaE?list=PLl1c3sCCatxOMd6r-aedJ8L__4wigcELE', 3),
	(29, '쪼꼬미 동물병원 마지막화 (원장님의 쪼꼬미 : 강아지 개똥이님, 까꿍이님)ㅣAnimal Hospital For Tiny Animals, Last Episode', '애니멀봐', 23751, './image/icon7.jpg', 'https://www.youtube.com/embed/rlQtqiMjKf0?list=PLl1c3sCCatxOMd6r-aedJ8L__4wigcELE', 3),
	(30, '쪼꼬미 동물병원 9화 (내원환자 : 거북이 배북이님)ㅣAnimal Hospital For Tiny Animals Ep. 9 (Patient: Baebook, Turtle)', '애니멀봐', 216444, './image/icon7.jpg', 'https://www.youtube.com/embed/27cP3FX-fL4?list=PLl1c3sCCatxOMd6r-aedJ8L__4wigcELE', 3),
	(31, '다시는 파란 대머리를 무시하지 마라.. [Faker Stream Highlight]', 'T1Faker', 32709, './image/icon8.jpg', 'https://www.youtube.com/embed/8CGQL3QWHxg', 4),
	(32, '미더덕과 만트라의 환상 조합 페이커의 미드 카르마! [Faker Stream Highlight]', 'T1Faker', 53718, './image/icon8.jpg', 'https://www.youtube.com/embed/s4CRuZDHHgQ', 4),
	(33, '크리스마스엔 핫초코 먹으면서 페이커 영상 보는 게 국룰이죠! [Faker Stream Highlight]', 'T1Faker', 56565, './image/icon8.jpg', 'https://www.youtube.com/embed/3U0Nwly0ZAw', 4),
	(34, '안전 벨트 꽉 매! 솔킬 드리프트 장인 페이커의 아지르! [Faker Stream Highlight]', 'T1Faker', 97696, './image/icon8.jpg', 'https://www.youtube.com/embed/dusPJKE1lok', 4),
	(35, '절대 그와 눈을 마주쳐선 안 돼.. 페이커의 리신! [Faker Stream Highlight]', 'T1Faker', 107105, './image/icon8.jpg', 'https://www.youtube.com/embed/wYQnSmyPXaU', 4),
	(36, '핑 100에서 스킬샷 맞추는 페드라가 레전드 ㅋㅋ [Faker Stream Highlight]', 'T1Faker', 23907, './image/icon8.jpg', 'https://www.youtube.com/embed/v4s4Ztl8JBs', 4),
	(37, '우물 레이저 [Faker Stream Highlight]', 'T1Faker', 97321, './image/icon8.jpg', 'https://www.youtube.com/embed/nufXBujnhlw', 4),
	(38, '미더덕과 만트라의 환상 조합 페이커의 미드 카르마! [Faker Stream Highlight]', 'T1Faker', 18663, './image/icon8.jpg', 'https://www.youtube.com/embed/s4CRuZDHHgQ', 4),
	(39, '올 겨울☃ 페니비아 어때~ [Faker Stream Highlight]', 'T1Faker', 9577, './image/icon8.jpg', 'https://www.youtube.com/embed/8MIiDnZPqtE', 4),
	(40, '이게 칼바람의 낭만이 아닐까요?  [Faker Stream Highlight]', 'T1Faker', 55105, './image/icon8.jpg', 'https://www.youtube.com/embed/BN4maFAGeH8', 4),
	(41, '워크래프트 스토리 한눈에 보기 완전판 (Warcraft Full Story Movie)', 'GCL 지씨엘', 95842, './image/icon5.jpg', 'https://www.youtube.com/embed/znV1MqFXwEo', 4),
	(42, '온갖 괴생명체로 가득찬 시설에서 탈출하기 (SCP Containment Breach 스토리)', 'GCL 지씨엘', 184014, './image/icon5.jpg', 'https://www.youtube.com/embed/-uXUDxi4DJU', 4),
	(43, '디아블로 스토리 한눈에 보기 완전판 (Diablo Story Full Movie)', 'GCL 지씨엘', 133097, './image/icon5.jpg', 'https://www.youtube.com/embed/walPS8mfpOc', 4),
	(44, '깊은 심해 속 살아 숨쉬는 괴생명체들의 정체  -  서브노티카 스토리 한눈에 보기 (Subnautica Full Game Story Movie)', 'GCL 지씨엘', 88960, './image/icon5.jpg', 'https://www.youtube.com/embed/TgTovn7Qn10', 4),
	(45, '리그 오브 레전드 세계관 한눈에 보기 - Part. 1', 'GCL 지씨엘', 127507, './image/icon5.jpg', 'https://www.youtube.com/embed/YCcE9oGkOw8', 4),
	(46, '우주를 구한 위대한 암흑 기사 - &quot;제라툴&quot; 이야기', 'GCL 지씨엘', 5074, './image/icon5.jpg', 'https://www.youtube.com/embed/o8SBRRSt-9w', 4),
	(47, '오버워치 스토리 한눈에 보기', 'GCL 지씨엘', 198706, './image/icon5.jpg', 'https://www.youtube.com/embed/39EgFz9BcDI', 4),
	(48, '60초 후에 핵폭탄이 떨어집니다.', 'GCL 지씨엘', 174533, './image/icon5.jpg', 'https://www.youtube.com/embed/ksGmVGmbDO0', 4),
	(49, '암네시아 : 더 다크 디센트 스토리 한눈에 보기', 'GCL 지씨엘', 122105, './image/icon5.jpg', 'https://www.youtube.com/embed/Ei86bHq958s', 4),
	(50, '살인 후 마네킹과 소개팅 시키는 미치광이 살인마 / 컨뎀드 스토리 한눈에 보기', 'GCL 지씨엘', 94579, './image/icon5.jpg', 'https://www.youtube.com/embed/0mdG6ocBnT0', 4),
	(51, 'Alan Walker and Au/Ra - Somebody Like U (Official Music Video)', 'Alan Walker', 103093, './image/icon6.jpg', 'https://www.youtube.com/embed/r6koyOHPNVI', 5),
	(52, 'Alan Walker - Faded', 'Alan Walker', 106356, './image/icon6.jpg', 'https://www.youtube.com/embed/60ItHLz5WEA', 5),
	(53, 'Alan Walker - Darkside (feat. Au/Ra and Tomine Harket)', 'Alan Walker', 124153, './image/icon6.jpg', 'https://www.youtube.com/embed/M-P4QBt-FWw', 5),
	(54, 'Alan Walker &amp; Ava Max - Alone, Pt. II (Live at Château de Fontainebleau)', 'Alan Walker', 137009, './image/icon6.jpg', 'https://www.youtube.com/embed/WrHDquZ-tj0', 5),
	(55, 'Alan Walker - The Drum (Official Music Video)', 'Alan Walker', 218781, './image/icon6.jpg', 'https://www.youtube.com/embed/TicGJQqrq2M', 5),
	(56, 'Alan Walker, Sabrina Carpenter &amp; Farruko  - On My Way', 'Alan Walker', 130304, './image/icon6.jpg', 'https://www.youtube.com/embed/dhYOPzcsbGM', 5),
	(57, 'Alan Walker, K-391, Tungevaag, Mangoo - PLAY (Alan Walker&#39;s Video)', 'Alan Walker', 218965, './image/icon6.jpg', 'https://www.youtube.com/embed/YQRHrco73g4', 5),
	(58, 'Lost Control', 'Alan Walker', 64710, './image/icon6.jpg', 'https://www.youtube.com/embed/vi6v0MOWp2Q', 5),
	(59, 'All Falls Down', 'Alan Walker', 35680, './image/icon6.jpg', 'https://www.youtube.com/embed/hK9mMhcLdiY?list=RDGMEMWO-g6DgCWEqKlDtKbJA1Gw', 5),
	(60, 'I Don&#39;t Wanna Go', 'Alan Walker', 208764, './image/icon6.jpg', 'https://www.youtube.com/embed/L6_Qj-cJMC0?list=RDGMEMWO-g6DgCWEqKlDtKbJA1Gw', 5),
	(61, '월드클래스 외데가르드 2023 스페셜', 'mtit1996', 107777, './image/icon3.jpg', 'https://www.youtube.com/embed/9xqLXJHyqXc', 6),
	(62, '부스케츠의 후계자 엔조 페르난데스 2022-23 스페셜', 'mtit1996', 11125, './image/icon3.jpg', 'https://www.youtube.com/embed/UJYlevRWLTI', 6),
	(63, '킬리안 음바페 2022-23 스페셜', 'mtit1996', 100826, './image/icon3.jpg', 'https://www.youtube.com/embed/zg8uEYr3k88', 6),
	(64, '벨기에이 만들어낸 천재 케빈 더 브라위너 2022-23 스페셜', 'mtit1996', 171767, './image/icon3.jpg', 'https://www.youtube.com/embed/A4csfGJ_B-0', 6),
	(65, '루카 모드리치 2022-23 스페셜', 'mtit1996', 54759, './image/icon3.jpg', 'https://www.youtube.com/embed/bN7qycH3dP8', 6),
	(66, '엘링 홀란드 2022-23 스페셜', 'mtit1996', 40173, './image/icon3.jpg', 'https://www.youtube.com/embed/3tKCfOEWGHg', 6),
	(67, '비니시우스 2022-23 스페셜 | 비니시우스의 몸값이 2,400억 원인 이유', 'mtit1996', 30502, './image/icon3.jpg', 'https://www.youtube.com/embed/AiIHQsvWUe0', 6),
	(68, '네이마르 2022-23 스페셜', 'mtit1996', 80850, './image/icon3.jpg', 'https://www.youtube.com/embed/U9VD6Ii3ywI', 6),
	(69, '황희찬 2020 스페셜', 'mtit1996', 84615, './image/icon3.jpg', 'https://www.youtube.com/embed/DUjLkiYI0Sk', 6),
	(70, '히샬리송 2022 스페셜', 'mtit1996', 31486, './image/icon3.jpg', 'https://www.youtube.com/embed/Dk5WWnwg0RI', 6),
	(71, '벤(BEN)의 킬링보이스를 라이브로!', '딩고뮤직', 31459, './image/icon4.jpg', 'https://www.youtube.com/embed/4bwRyeT1afM', 7),
	(72, '폴킴(Paul Kim)의 킬링보이스를 라이브로!', '딩고뮤직', 295606, './image/icon4.jpg', 'https://www.youtube.com/embed/JbUSH6ZZ1LU', 7),
	(73, '양다일(Yang Da-Il)의 킬링보이스를 라이브로!', '딩고뮤직', 126167, './image/icon4.jpg', 'https://www.youtube.com/embed/k02azAGf5ew', 7),
	(74, '린(LYN)의 킬링보이스를 라이브로!', '딩고뮤직', 551024, './image/icon4.jpg', 'https://www.youtube.com/embed/0vvCe4EHtus', 7),
	(75, '김나영(Kim Na Young)의 킬링보이스를 라이브로', '딩고뮤직', 213310, './image/icon4.jpg', 'https://www.youtube.com/embed/45Vey0yUylc', 7),
	(76, '별(BYUL)의 킬링보이스를 라이브로!', '딩고뮤직', 692100, './image/icon4.jpg', 'https://www.youtube.com/embed/n1GwrrQL6O0', 7),
	(77, '허각(Huh Gak)의 킬링보이스를 라이브로', '딩고뮤직', 118451, './image/icon4.jpg', 'https://www.youtube.com/embed/cBN7T8WjvXc', 7),
	(78, '카라(KARA)의 킬링보이스를 라이브로!', '딩고뮤직', 58795, './image/icon4.jpg', 'https://www.youtube.com/embed/VNYEHXsehTg', 7),
	(79, 'EXID(이엑스아이디)의 킬링보이스를 라이브로', '딩고뮤직', 147428, './image/icon4.jpg', 'https://www.youtube.com/embed/U8M8LNnWMzk', 7),
	(80, '성시경(Sungsikyung)의 킬링보이스를 라이브로!', '딩고뮤직', 86535, './image/icon4.jpg', 'https://www.youtube.com/embed/6RQ-bBdASvk', 7);
/*!40000 ALTER TABLE `youtubeList` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeList_backup 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeList_backup` (
  `idx` int(11) NOT NULL DEFAULT '0',
  `subject` varchar(300) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `readcount` int(11) NOT NULL,
  `thum` varchar(100) NOT NULL,
  `url` varchar(500) NOT NULL,
  `category` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeList_backup:~80 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeList_backup` DISABLE KEYS */;
INSERT INTO `youtubeList_backup` (`idx`, `subject`, `writer`, `readcount`, `thum`, `url`, `category`) VALUES
	(1, '[한글자막] 윤도현에게 2002 월드컵 수익을 묻다', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/rGa2r9uPtUg', 2),
	(2, '[05학번이즈히어] 신도시 고깃집 여사장은 어떻게 일하는가', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/1Hu2sHhsSPI', 2),
	(3, '[한글자막] 립제이에게 쿨제이를 묻다', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/yU_Gx7Ncs9s', 2),
	(4, '[05학번이즈히어] 신도시 카페 사장은 어떻게 사는가', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/NsRPxHC84qw', 2),
	(5, '아바타: 물의 길 오디션 지원 영상 (배우 정재형);', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/iahwr75Wfc4', 2),
	(6, '[한글자막] 박재범에게 원소주 원가를 묻다', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/qW8pEIocLkU', 2),
	(7, '(161224); 길은지♥️조정구 예비부부 가편집본2 (신랑 전달용);', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/9NoBGXrc5RY', 2),
	(8, '[한글자막] 카모에게 전화번호를 묻다', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/fKaBhqrlXdY', 2),
	(9, '도요다 부장님이 계약 성공 후 꼭 들르는 힐링 맛집?!', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/YndDkf7yVPk', 2),
	(10, '[05학번이즈히어] 신도시 부부는 결혼기념일에 무엇을 하는가', '피식대학', 0, './image/icon10.jpg', 'https://www.youtube.com/embed/yuNQheV5Zsk', 2),
	(11, '환타로 만든 뱅쇼 vs 쌍화탕으로 만든 모주', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/0pw5gBIAWQM?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(12, '2021년은 어땠나? 2022년은 어떨까?', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/rwYoIzl5o9U?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(13, '치킨계의 냉전시대', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/-YZ_z_TRBnY?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(14, '90년대 애니 여캐 둘러보기', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/IcTjuJGoPbQ?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(15, '저가요 거위인데요', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/bDKA_p8jhSw?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(16, '꽁치가처넌의 멸망의 노래!', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/qMc79yi2N4A?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(17, '침착맨과 인기웹툰 \'나 혼자만 레벨업\' 같이 보기', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/Z__KMr6QLEQ?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(18, '맞기 싫은 몽둥이 월드컵', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/V0pNWjWlazo?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(19, '새해 금연합니다, 현상금 1000만원', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/yJI9iCKlD9A?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(20, '특이한 벌레와 새 이야기', '침착맨', 0, './image/icon9.jpg', 'https://www.youtube.com/embed/5T_4pnS6nxA?list=PLif_jr7pPZAD8EJtkFBBctqm5L38JqtGb', 2),
	(21, '그 시절 우리가 사랑했던 쪼꼬미 동물병원 1~12화 모아보기ㅣBinge-Watch On Animal Hospital For Tiny Animals', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/nNh9bO5xdso', 3),
	(22, '쪼꼬미와 한 시간의 행방불명 쪼꼬미 동물병원2 1~12화 모아보기ㅣBinge-Watch On Animal Hospital For Tiny Animals 2', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/pHNaSDoDFLQ', 3),
	(23, '추석 연휴 종료 기념 (나 우냐..) 나새끼 종합 선물 셋뚜셋뚜ㅣI’m THE Baby Compilation Gift Box', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/zwgJSbTo884', 3),
	(24, '쪼꼬미 동물병원 8화 (내원환자 : 드워프햄스터 두부님)ㅣAnimal Hospital for Tiny Animals Ep 8 (Patient: Dubu, Dwarf Hamster)', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/nLzPsYyVD6w', 3),
	(25, '쪼꼬미 동물병원 시즌2 1화 (내원환자 : 드워프햄스터 두부님)ㅣAnimal Hospital for Tiny Animals2 Ep 1(Patient: Dubu, Hamster)', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/DXeroPf0MFs', 3),
	(26, '쪼꼬미 동물병원 시즌2 11화 (내원환자: 라쿤 설기님)ㅣAnimal Hospital for Tiny Animals2 Ep 11 (Patient: Seolgi, Raccoon)', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/SXMkDjlLp8Q', 3),
	(27, '쪼꼬미 동물병원 시즌2 6화 (내원환자: 푸딩 햄스터 밍키님)', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/JiDghYNKYL8', 3),
	(28, '쪼꼬미 동물병원 2화 (내원환자 : 미어캣 순둥이님)ㅣReason Why A Cheerful Meerkat Came To The Animal Hospital', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/xDOlKAFpAaE?list=PLl1c3sCCatxOMd6r-aedJ8L__4wigcELE', 3),
	(29, '쪼꼬미 동물병원 마지막화 (원장님의 쪼꼬미 : 강아지 개똥이님, 까꿍이님)ㅣAnimal Hospital For Tiny Animals, Last Episode', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/rlQtqiMjKf0?list=PLl1c3sCCatxOMd6r-aedJ8L__4wigcELE', 3),
	(30, '쪼꼬미 동물병원 9화 (내원환자 : 거북이 배북이님)ㅣAnimal Hospital For Tiny Animals Ep. 9 (Patient: Baebook, Turtle)', '애니멀봐', 0, './image/icon7.jpg', 'https://www.youtube.com/embed/27cP3FX-fL4?list=PLl1c3sCCatxOMd6r-aedJ8L__4wigcELE', 3),
	(31, '다시는 파란 대머리를 무시하지 마라.. [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/8CGQL3QWHxg', 4),
	(32, '미더덕과 만트라의 환상 조합 페이커의 미드 카르마! [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/s4CRuZDHHgQ', 4),
	(33, '크리스마스엔 핫초코 먹으면서 페이커 영상 보는 게 국룰이죠! [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/3U0Nwly0ZAw', 4),
	(34, '안전 벨트 꽉 매! 솔킬 드리프트 장인 페이커의 아지르! [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/dusPJKE1lok', 3),
	(35, '절대 그와 눈을 마주쳐선 안 돼.. 페이커의 리신! [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/wYQnSmyPXaU', 4),
	(36, '핑 100에서 스킬샷 맞추는 페드라가 레전드 ㅋㅋ [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/v4s4Ztl8JBs', 4),
	(37, '우물 레이저 [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/nufXBujnhlw', 4),
	(38, '미더덕과 만트라의 환상 조합 페이커의 미드 카르마! [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/s4CRuZDHHgQ', 4),
	(39, '올 겨울☃ 페니비아 어때~ [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/8MIiDnZPqtE', 4),
	(40, '이게 칼바람의 낭만이 아닐까요?  [Faker Stream Highlight]', 'T1Faker', 0, './image/icon8.jpg', 'https://www.youtube.com/embed/BN4maFAGeH8', 4),
	(41, '워크래프트 스토리 한눈에 보기 완전판 (Warcraft Full Story Movie)', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/znV1MqFXwEo', 4),
	(42, '온갖 괴생명체로 가득찬 시설에서 탈출하기 (SCP Containment Breach 스토리)', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/-uXUDxi4DJU', 4),
	(43, '디아블로 스토리 한눈에 보기 완전판 (Diablo Story Full Movie)', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/walPS8mfpOc', 4),
	(44, '깊은 심해 속 살아 숨쉬는 괴생명체들의 정체  -  서브노티카 스토리 한눈에 보기 (Subnautica Full Game Story Movie)', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/TgTovn7Qn10', 4),
	(45, '리그 오브 레전드 세계관 한눈에 보기 - Part. 1', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/YCcE9oGkOw8', 4),
	(46, '우주를 구한 위대한 암흑 기사 - &quot;제라툴&quot; 이야기', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/o8SBRRSt-9w', 4),
	(47, '오버워치 스토리 한눈에 보기', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/39EgFz9BcDI', 4),
	(48, '60초 후에 핵폭탄이 떨어집니다.', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/ksGmVGmbDO0', 4),
	(49, '암네시아 : 더 다크 디센트 스토리 한눈에 보기', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/Ei86bHq958s', 4),
	(50, '살인 후 마네킹과 소개팅 시키는 미치광이 살인마 / 컨뎀드 스토리 한눈에 보기', 'GCL 지씨엘', 0, './image/icon5.jpg', 'https://www.youtube.com/embed/0mdG6ocBnT0', 4),
	(51, 'Alan Walker and Au/Ra - Somebody Like U (Official Music Video)', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/r6koyOHPNVI', 5),
	(52, 'Alan Walker - Faded', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/60ItHLz5WEA', 5),
	(53, 'Alan Walker - Darkside (feat. Au/Ra and Tomine Harket)', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/M-P4QBt-FWw', 5),
	(54, 'Alan Walker &amp; Ava Max - Alone, Pt. II (Live at Château de Fontainebleau)', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/WrHDquZ-tj0', 5),
	(55, 'Alan Walker - The Drum (Official Music Video)', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/TicGJQqrq2M', 5),
	(56, 'Alan Walker, Sabrina Carpenter &amp; Farruko  - On My Way', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/dhYOPzcsbGM', 5),
	(57, 'Alan Walker, K-391, Tungevaag, Mangoo - PLAY (Alan Walker&#39;s Video)', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/YQRHrco73g4', 5),
	(58, 'Lost Control', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/vi6v0MOWp2Q', 5),
	(59, 'All Falls Down', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/hK9mMhcLdiY?list=RDGMEMWO-g6DgCWEqKlDtKbJA1Gw', 5),
	(60, 'I Don&#39;t Wanna Go', 'Alan Walker', 0, './image/icon6.jpg', 'https://www.youtube.com/embed/L6_Qj-cJMC0?list=RDGMEMWO-g6DgCWEqKlDtKbJA1Gw', 5),
	(61, '월드클래스 외데가르드 2023 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/9xqLXJHyqXc', 6),
	(62, '부스케츠의 후계자 엔조 페르난데스 2022-23 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/UJYlevRWLTI', 6),
	(63, '킬리안 음바페 2022-23 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/zg8uEYr3k88', 6),
	(64, '벨기에이 만들어낸 천재 케빈 더 브라위너 2022-23 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/A4csfGJ_B-0', 6),
	(65, '루카 모드리치 2022-23 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/bN7qycH3dP8', 6),
	(66, '엘링 홀란드 2022-23 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/3tKCfOEWGHg', 6),
	(67, '비니시우스 2022-23 스페셜 | 비니시우스의 몸값이 2,400억 원인 이유', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/AiIHQsvWUe0', 6),
	(68, '네이마르 2022-23 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/U9VD6Ii3ywI', 6),
	(69, '황희찬 2020 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/DUjLkiYI0Sk', 6),
	(70, '히샬리송 2022 스페셜', 'mtit1996', 0, './image/icon3.jpg', 'https://www.youtube.com/embed/Dk5WWnwg0RI', 6),
	(71, '벤(BEN)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/4bwRyeT1afM', 7),
	(72, '폴킴(Paul Kim)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/JbUSH6ZZ1LU', 7),
	(73, '양다일(Yang Da-Il)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/k02azAGf5ew', 7),
	(74, '린(LYN)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/0vvCe4EHtus', 7),
	(75, '김나영(Kim Na Young)의 킬링보이스를 라이브로', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/45Vey0yUylc', 7),
	(76, '별(BYUL)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/n1GwrrQL6O0', 7),
	(77, '허각(Huh Gak)의 킬링보이스를 라이브로', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/cBN7T8WjvXc', 7),
	(78, '카라(KARA)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/VNYEHXsehTg', 7),
	(79, 'EXID(이엑스아이디)의 킬링보이스를 라이브로', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/U8M8LNnWMzk', 7),
	(80, '성시경(Sungsikyung)의 킬링보이스를 라이브로!', '딩고뮤직', 0, './image/icon4.jpg', 'https://www.youtube.com/embed/6RQ-bBdASvk', 7);
/*!40000 ALTER TABLE `youtubeList_backup` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeMyComment 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeMyComment` (
  `content` varchar(255) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `nowdate` datetime DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `writer` varchar(100) DEFAULT NULL,
  `readcount` int(11) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `thum` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeMyComment:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeMyComment` DISABLE KEYS */;
/*!40000 ALTER TABLE `youtubeMyComment` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeMyView 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeMyView` (
  `idx` int(11) NOT NULL,
  `user_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeMyView:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeMyView` DISABLE KEYS */;
INSERT INTO `youtubeMyView` (`idx`, `user_id`) VALUES
	(53, '손님'),
	(40, '손님'),
	(5, 'test'),
	(28, 'aa'),
	(28, 'aa'),
	(63, 'aa'),
	(63, 'aa');
/*!40000 ALTER TABLE `youtubeMyView` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubePlayComment 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubePlayComment` (
  `idx` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `nowdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `nikname` varchar(50) NOT NULL,
  `user_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubePlayComment:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubePlayComment` DISABLE KEYS */;
INSERT INTO `youtubePlayComment` (`idx`, `comment_id`, `content`, `user_id`, `nowdate`, `nikname`, `user_img`) VALUES
	(28, 1, '너무 귀요워요', 'aa', '2023-02-24 16:41:40', '건짱최고', './image/default.jpg'),
	(63, 2, '도라메ㅗㅇ', 'aa', '2023-02-24 16:43:13', '건짱최고', './upload/0.9663560567736293test.png');
/*!40000 ALTER TABLE `youtubePlayComment` ENABLE KEYS */;

-- 테이블 dbrjsdml.youtubeUser 구조 내보내기
CREATE TABLE IF NOT EXISTS `youtubeUser` (
  `user_idx` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `user_pw` varchar(100) NOT NULL,
  `user_nikname` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_img` varchar(500) NOT NULL,
  PRIMARY KEY (`user_idx`),
  UNIQUE KEY `USER_ID_UK` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 dbrjsdml.youtubeUser:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `youtubeUser` DISABLE KEYS */;
INSERT INTO `youtubeUser` (`user_idx`, `user_id`, `user_pw`, `user_nikname`, `user_email`, `user_img`) VALUES
	(1, '손님', '손님', '손님', 'dbrjsdml@naver.com', './image/default.jpg'),
	(2, 'test', 'test', 'test', 'test@naver.com', './image/default.jpg'),
	(3, 'aa', 'aaa', '건짱최고', 'aa@naver.com', './upload/0.9663560567736293test.png');
/*!40000 ALTER TABLE `youtubeUser` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
