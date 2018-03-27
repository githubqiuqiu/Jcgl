/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-03-27 15:27:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aschool` varchar(30) NOT NULL,
  `amajor` varchar(50) NOT NULL,
  `aflag` int(11) DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '牛津', '', '0');
INSERT INTO `academy` VALUES ('2', '哈佛', '', '1');

-- ----------------------------
-- Table structure for acaspe
-- ----------------------------
DROP TABLE IF EXISTS `acaspe`;
CREATE TABLE `acaspe` (
  `asid` int(11) NOT NULL AUTO_INCREMENT,
  `acid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  PRIMARY KEY (`asid`),
  KEY `FK_acid_academy` (`acid`),
  KEY `FK_sid_specialty` (`sid`),
  CONSTRAINT `FK_acid_academy` FOREIGN KEY (`acid`) REFERENCES `academy` (`aid`),
  CONSTRAINT `FK_sid_specialty` FOREIGN KEY (`sid`) REFERENCES `specialty` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acaspe
-- ----------------------------
INSERT INTO `acaspe` VALUES ('1', '1', '1');
INSERT INTO `acaspe` VALUES ('2', '1', '2');
INSERT INTO `acaspe` VALUES ('3', '1', '3');
INSERT INTO `acaspe` VALUES ('4', '2', '1');
INSERT INTO `acaspe` VALUES ('5', '2', '2');

-- ----------------------------
-- Table structure for accountantapply
-- ----------------------------
DROP TABLE IF EXISTS `accountantapply`;
CREATE TABLE `accountantapply` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `astudentno` varchar(20) NOT NULL,
  `aname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `aphone` varchar(20) NOT NULL,
  `acontent` varchar(20) NOT NULL,
  `cityid` int(11) NOT NULL,
  `countyid` varchar(30) NOT NULL,
  `adata` datetime NOT NULL,
  PRIMARY KEY (`aid`),
  KEY `FK_userid_accountant` (`userid`),
  KEY `FKD6E2F14E52FE23B` (`cityid`),
  CONSTRAINT `FKD6E2F14E52FE23B` FOREIGN KEY (`cityid`) REFERENCES `city` (`cid`),
  CONSTRAINT `FK_userid_accountant` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accountantapply
-- ----------------------------
INSERT INTO `accountantapply` VALUES ('1', '1', '李四', '1', '12123123', '会计', '1', '1', '2017-08-23 14:25:29');

-- ----------------------------
-- Table structure for accountantfinance
-- ----------------------------
DROP TABLE IF EXISTS `accountantfinance`;
CREATE TABLE `accountantfinance` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `tid` int(11) NOT NULL,
  `needmoney` int(11) NOT NULL,
  `practicalmoney` int(11) NOT NULL,
  `fdata` varchar(50) DEFAULT NULL,
  `fway` varchar(20) DEFAULT NULL,
  `fstatu` int(11) NOT NULL,
  `ftest1` int(11) DEFAULT NULL,
  `ftest2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accountantfinance
-- ----------------------------
INSERT INTO `accountantfinance` VALUES ('1', '1', '小天', '2', '6000', '6000', '2017-9-10 20:51:56', '现金', '2', null, null);

-- ----------------------------
-- Table structure for adultapply
-- ----------------------------
DROP TABLE IF EXISTS `adultapply`;
CREATE TABLE `adultapply` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `astudentno` varchar(20) NOT NULL,
  `aname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `idnumber` varchar(20) NOT NULL,
  `aphone` varchar(20) NOT NULL,
  `atype` int(11) NOT NULL DEFAULT '0',
  `acaid` int(11) NOT NULL,
  `specid` int(11) NOT NULL,
  `agradation` varchar(20) NOT NULL,
  `asystem` varchar(20) NOT NULL,
  `cityid` int(11) NOT NULL,
  `adata` datetime NOT NULL,
  `countyid` int(11) NOT NULL,
  PRIMARY KEY (`aid`),
  KEY `FK_userid_user` (`userid`),
  KEY `FK111765F44CFACC4A` (`specid`),
  KEY `FK111765F49799BBB9` (`countyid`),
  KEY `FK111765F4E52FE23B` (`cityid`),
  KEY `FK111765F4911B1B7C` (`acaid`),
  CONSTRAINT `FK111765F44CFACC4A` FOREIGN KEY (`specid`) REFERENCES `specialty` (`sid`),
  CONSTRAINT `FK111765F4911B1B7C` FOREIGN KEY (`acaid`) REFERENCES `academy` (`aid`),
  CONSTRAINT `FK111765F49799BBB9` FOREIGN KEY (`countyid`) REFERENCES `county` (`coid`),
  CONSTRAINT `FK111765F4E52FE23B` FOREIGN KEY (`cityid`) REFERENCES `city` (`cid`),
  CONSTRAINT `FK_userid_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adultapply
-- ----------------------------
INSERT INTO `adultapply` VALUES ('1', '1', '张三疯', '1', '1234', '1234', '0', '1', '1', '高达专', '三年', '1', '2017-08-23 14:25:27', '2');
INSERT INTO `adultapply` VALUES ('2', '2', '宏大发', '12', '1234', '1234', '0', '1', '1', '高达专', '两年', '3', '2017-08-29 08:41:19', '8');
INSERT INTO `adultapply` VALUES ('8', '3', '小明', '1', '123', '123', '0', '1', '3', '高达专', '两年', '1', '2017-08-31 10:44:45', '1');
INSERT INTO `adultapply` VALUES ('9', '4', '小红', '13', '123', '123', '0', '2', '2', '高达本', '两年', '2', '2017-08-31 10:52:58', '10');
INSERT INTO `adultapply` VALUES ('10', '5', '小花花', '1', '123', '123', '0', '2', '2', '高达本', '两年', '2', '2017-08-31 15:32:58', '10');
INSERT INTO `adultapply` VALUES ('12', '6', '学生6', '1', '1', '1234567890', '0', '1', '1', '高达专', '两年', '1', '2017-09-11 16:00:25', '1');
INSERT INTO `adultapply` VALUES ('13', '7', '学生7', '2', '12', '123456789', '0', '2', '1', '高达本', '三年', '2', '2017-09-11 16:00:25', '9');
INSERT INTO `adultapply` VALUES ('14', '8', '学生8', '12', '123', '12345678', '0', '1', '2', '专达本', '两年', '3', '2017-09-11 16:00:26', '4');
INSERT INTO `adultapply` VALUES ('15', '9', '学生9', '13', '1234', '1234567', '0', '2', '2', '高达专', '两年', '1', '2017-09-11 16:00:26', '2');
INSERT INTO `adultapply` VALUES ('16', '10', '学生10', '14', '12345', '123456', '0', '1', '3', '高达本', '三年', '2', '2017-09-11 16:00:26', '10');
INSERT INTO `adultapply` VALUES ('17', '11', '学生11', '1', '123456', '12345', '0', '2', '1', '专达本', '两年', '3', '2017-09-11 16:00:26', '5');
INSERT INTO `adultapply` VALUES ('18', '12', '学生12', '2', '1234567', '1234', '0', '1', '1', '高达专', '两年', '1', '2017-09-11 16:00:26', '3');
INSERT INTO `adultapply` VALUES ('19', '13', '学生13', '12', '12345678', '123', '0', '2', '2', '高达本', '三年', '2', '2017-09-11 16:00:26', '9');
INSERT INTO `adultapply` VALUES ('20', '14', '学生14', '13', '123456789', '12', '0', '1', '2', '专达本', '两年', '3', '2017-09-11 16:00:26', '6');
INSERT INTO `adultapply` VALUES ('21', '15', '学生15', '14', '1234567890', '1', '0', '2', '1', '高达专', '两年', '3', '2017-09-11 16:00:27', '7');

-- ----------------------------
-- Table structure for adultfinance
-- ----------------------------
DROP TABLE IF EXISTS `adultfinance`;
CREATE TABLE `adultfinance` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `schoolid` int(11) NOT NULL,
  `majorid` int(11) NOT NULL,
  `gradation` varchar(30) NOT NULL,
  `tid` int(11) NOT NULL,
  `needmoney` int(11) NOT NULL,
  `practicalmoney` int(11) NOT NULL,
  `fdata` varchar(50) DEFAULT NULL,
  `fway` varchar(20) DEFAULT NULL,
  `fstatu` int(11) NOT NULL,
  `ftest1` int(11) DEFAULT NULL,
  `ftest2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `FK2541A8E0B3FB02C8` (`majorid`),
  KEY `FK2541A8E0628E1531` (`schoolid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adultfinance
-- ----------------------------
INSERT INTO `adultfinance` VALUES ('1', '3', '小明', '1', '3', '高达专', '1', '6000', '5000', '2017-9-10 20:44:55', '微信', '1', null, null);
INSERT INTO `adultfinance` VALUES ('2', '4', '小红', '2', '2', '高达本', '13', '10000', '2000', '2017-9-10 20:51:11', '微信', '1', null, null);
INSERT INTO `adultfinance` VALUES ('5', '6', '学生6', '1', '1', '高达专', '1', '6000', '1000', '2017-9-11 21:15:41', '支付宝', '1', null, null);
INSERT INTO `adultfinance` VALUES ('6', '7', '学生7', '2', '1', '高达本', '2', '10000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('7', '8', '学生8', '1', '2', '专达本', '12', '8000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('8', '9', '学生9', '2', '2', '高达专', '13', '6000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('9', '10', '学生10', '1', '3', '高达本', '14', '10000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('10', '11', '学生11', '2', '1', '专达本', '1', '8000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('11', '12', '学生12', '1', '1', '高达专', '2', '6000', '1000', '2017-9-13 10:11:33', '银行转账', '1', null, null);
INSERT INTO `adultfinance` VALUES ('12', '13', '学生13', '2', '2', '高达本', '12', '10000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('13', '14', '学生14', '1', '2', '专达本', '13', '8000', '0', null, null, '0', null, null);
INSERT INTO `adultfinance` VALUES ('14', '15', '学生15', '2', '1', '高达专', '14', '6000', '0', null, null, '0', null, null);

-- ----------------------------
-- Table structure for applytype
-- ----------------------------
DROP TABLE IF EXISTS `applytype`;
CREATE TABLE `applytype` (
  `atid` int(11) NOT NULL AUTO_INCREMENT,
  `atname` varchar(20) NOT NULL,
  PRIMARY KEY (`atid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applytype
-- ----------------------------
INSERT INTO `applytype` VALUES ('1', '高达专');
INSERT INTO `applytype` VALUES ('2', '高达本');
INSERT INTO `applytype` VALUES ('3', '专升本');

-- ----------------------------
-- Table structure for artapply
-- ----------------------------
DROP TABLE IF EXISTS `artapply`;
CREATE TABLE `artapply` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `astudentno` varchar(20) NOT NULL,
  `aname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `aphone` varchar(20) NOT NULL,
  `acontent` varchar(20) NOT NULL,
  `cityid` int(11) NOT NULL,
  `countyid` varchar(30) NOT NULL,
  `adata` datetime NOT NULL,
  PRIMARY KEY (`aid`),
  KEY `FK_userid_artapply` (`userid`),
  KEY `FKB6560EEBE52FE23B` (`cityid`),
  CONSTRAINT `FKB6560EEBE52FE23B` FOREIGN KEY (`cityid`) REFERENCES `city` (`cid`),
  CONSTRAINT `FK_userid_artapply` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artapply
-- ----------------------------
INSERT INTO `artapply` VALUES ('1', '1', '刘七', '1', '12123123', '艺术', '1', '1', '2017-08-23 14:25:35');

-- ----------------------------
-- Table structure for artfinance
-- ----------------------------
DROP TABLE IF EXISTS `artfinance`;
CREATE TABLE `artfinance` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `tid` int(11) NOT NULL,
  `needmoney` int(11) NOT NULL,
  `practicalmoney` int(11) NOT NULL,
  `fdata` varchar(50) DEFAULT NULL,
  `fway` varchar(20) DEFAULT NULL,
  `fstatu` int(11) NOT NULL,
  `ftest1` int(11) DEFAULT NULL,
  `ftest2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artfinance
-- ----------------------------
INSERT INTO `artfinance` VALUES ('1', '1', '张萌', '1', '10000', '3000', '2017-9-11 21:16:19', '支付宝', '1', null, null);
INSERT INTO `artfinance` VALUES ('2', '2', '刘怡', '2', '10000', '1000', '2017-9-14 15:48:30', '支付宝', '1', null, null);

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '上海');
INSERT INTO `city` VALUES ('2', '广州');
INSERT INTO `city` VALUES ('3', '江西');

-- ----------------------------
-- Table structure for county
-- ----------------------------
DROP TABLE IF EXISTS `county`;
CREATE TABLE `county` (
  `coid` int(11) NOT NULL AUTO_INCREMENT,
  `coname` varchar(20) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`coid`),
  KEY `FK_cid_city` (`cid`),
  CONSTRAINT `FK_cid_city` FOREIGN KEY (`cid`) REFERENCES `city` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of county
-- ----------------------------
INSERT INTO `county` VALUES ('1', '浦东', '1');
INSERT INTO `county` VALUES ('2', '黄埔', '1');
INSERT INTO `county` VALUES ('3', '奉贤', '1');
INSERT INTO `county` VALUES ('4', '南昌', '3');
INSERT INTO `county` VALUES ('5', '抚州', '3');
INSERT INTO `county` VALUES ('6', '赣州', '3');
INSERT INTO `county` VALUES ('7', '赣县', '3');
INSERT INTO `county` VALUES ('8', '全南', '3');
INSERT INTO `county` VALUES ('9', '番禺', '2');
INSERT INTO `county` VALUES ('10', '白云', '2');

-- ----------------------------
-- Table structure for distanceapply
-- ----------------------------
DROP TABLE IF EXISTS `distanceapply`;
CREATE TABLE `distanceapply` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dstudentno` varchar(20) NOT NULL,
  `dname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `idnumber` varchar(20) NOT NULL,
  `dphone` varchar(20) NOT NULL,
  `dtype` int(11) NOT NULL DEFAULT '0',
  `acaid` int(11) NOT NULL,
  `specid` int(11) NOT NULL,
  `dgradation` varchar(20) NOT NULL,
  `dsystem` varchar(20) NOT NULL,
  `cityid` int(11) NOT NULL,
  `countyid` varchar(30) NOT NULL,
  `ddata` datetime NOT NULL,
  PRIMARY KEY (`did`),
  KEY `FK_userid_distance` (`userid`),
  KEY `FKDEAC28994CFACC4A` (`specid`),
  KEY `FKDEAC2899E52FE23B` (`cityid`),
  KEY `FKDEAC2899911B1B7C` (`acaid`),
  CONSTRAINT `FKDEAC28994CFACC4A` FOREIGN KEY (`specid`) REFERENCES `specialty` (`sid`),
  CONSTRAINT `FKDEAC2899911B1B7C` FOREIGN KEY (`acaid`) REFERENCES `academy` (`aid`),
  CONSTRAINT `FKDEAC2899E52FE23B` FOREIGN KEY (`cityid`) REFERENCES `city` (`cid`),
  CONSTRAINT `FK_userid_distance` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of distanceapply
-- ----------------------------
INSERT INTO `distanceapply` VALUES ('1', '1', '赵六', '1', '123132', '123123', '0', '1', '1', '高达本', '四年', '2', '10', '2017-08-23 14:25:33');
INSERT INTO `distanceapply` VALUES ('2', '2', '小明', '2', '12345', '12345', '0', '1', '3', '高达专', '两年', '1', '1', '2017-08-30 20:16:06');
INSERT INTO `distanceapply` VALUES ('4', '3', '宏大大发', '2', '123', '123', '0', '2', '2', '专升本', '两年', '3', '4', '2017-08-31 11:14:53');

-- ----------------------------
-- Table structure for distancefinance
-- ----------------------------
DROP TABLE IF EXISTS `distancefinance`;
CREATE TABLE `distancefinance` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `schoolid` int(11) NOT NULL,
  `majorid` int(11) NOT NULL,
  `gradation` varchar(30) NOT NULL,
  `tid` int(11) NOT NULL,
  `needmoney` int(11) NOT NULL,
  `practicalmoney` int(11) NOT NULL,
  `fdata` varchar(50) DEFAULT NULL,
  `fway` varchar(20) DEFAULT NULL,
  `fstatu` int(11) NOT NULL,
  `ftest1` int(11) DEFAULT NULL,
  `ftest2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `FKE0B05645B3FB02C8` (`majorid`),
  KEY `FKE0B05645628E1531` (`schoolid`),
  CONSTRAINT `FKE0B05645628E1531` FOREIGN KEY (`schoolid`) REFERENCES `academy` (`aid`),
  CONSTRAINT `FKE0B05645B3FB02C8` FOREIGN KEY (`majorid`) REFERENCES `specialty` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of distancefinance
-- ----------------------------
INSERT INTO `distancefinance` VALUES ('1', '3', '宏大大发', '2', '2', '专升本', '2', '8000', '6000', '2017-9-11 21:16:11', '现金', '1', null, null);

-- ----------------------------
-- Table structure for eguide
-- ----------------------------
DROP TABLE IF EXISTS `eguide`;
CREATE TABLE `eguide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `picture1` varchar(255) DEFAULT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `picture2` varchar(255) DEFAULT NULL,
  `picture3` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB23BB1B78B95C6BD` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eguide
-- ----------------------------
INSERT INTO `eguide` VALUES ('4', '1505132653808367075.png', '北京外国语大学，简称北外，由中华人民共和国教育部直属，位列国家首批“211工程”，入选“985工程优势学科创新平台”、“2011计划”', '1505132653810544051.jpg', '北京外国语大学（Beijing Foreign Studies University），简称北外，由中华人民共和国教育部直属，位列国家首批“211工程”，入选“985工程优势学科创新平台”、“2011计划”，为财政部6所“小规模试点高校“之一，国际大学翻译学院联合会成员，设有研究生院，是中国外国语类高等院校中历史悠久、教授语种最多、办学层次齐全的全国重点大学，被誉为“共和国外交官摇篮”。 北京外国语大学前身是1941年成立于延安的中国人民抗日军事政治大学三分校俄文大队，后发展为延安外国语学校，建校始隶属于中国共产党领导。新中国成立后，学校归外交部领导。1954年，更名为北京外国语学院；1959年，与北京俄语学院合并组建新的北京外国语学院。1980年后直属国家教育部领导。1994年，正式更名为北京外国语大学。', '1505132653812567171.png', '1505132653812868830.png', '北京外国语');
INSERT INTO `eguide` VALUES ('5', '1505132715454224675.png', '电子科技大学简称电子科大，坐落于有“天府之国”之称的成都市，由中华人民共和国教育部直属，位列“211工程”、“985工程”，入选国家“2011计划”、“111计划”、“卓越工程师教育培养计划”', '1505132715457523304.jpg', '电子科技大学（University of Electronic Science and Technology of China）简称电子科大，坐落于有“天府之国”之称的成都市，由中华人民共和国教育部直属，位列“211工程”、“985工程”，入选国家“2011计划”、“111计划”、“卓越工程师教育培养计划”，两电一邮成员，设有研究生院，是一所以电子信息科学技术为核心的全国重点大学，被誉为“中国电子类院校的排头兵”。 电子科技大学原名成都电讯工程学院，是1956年在周恩来总理的亲自部署下，由交通大学（现上海交通大学、西安交通大学）、南京工学院（现东南大学）、华南工学院（现华南理工大学）的电讯工程有关专业合并创建而成。1960年，被中共中央列为全国重点高等学校；1961年，被中共中央确定为七所国防工业院校之一。1988年，更名为电子科技大学。1997年，被确定为国家首批“211工程”建设的重点大学。2000年，由原信息产业部主管划转为教育部主管。2001年，进入国家“985工程”重点建设大学行列。', '1505132715458561084.png', '1505132715459919567.png', '电子科技大学');
INSERT INTO `eguide` VALUES ('6', '1505132779169551432.png', '涵盖法学 、行政管理 、会计学 、英语 、汉语言文学 、体育教育 、艺术设计学 、市场营销 、电子信息工程 、计算机科学与技术 、通信工程 、自动化 、资源勘查工程 、土木工程 、测绘工程广告学', '1505132779171775396.png', '东华理工大学位于著名的“才子之乡”——江西省抚州市，是江西省人民政府与工业和信息化部国防科技工业局（原国防科工委）共建的一所具有地学和核科学特色，以理工为主，文、管、经、法、教兼备的综合性大学。 学校现有在校生29000余人（含留学生），是全国首批学士学位和第四批硕士学位授权单位。现有57个本科专业，其中11个国防军工专业、1个国防重点专业、1个国防紧缺专业、3个国家级特色专业、14个江西省品牌专业、8个省级特色专业，14个省部级重点学科，65个硕士点，有4个专业合作培养博士生，有10个领域的工程硕士学位授予权，具有在职人员以同等学历申请硕士学位授权资格。', '1505132779173630375.png', '1505132779174366312.png', '东华理工大学');
INSERT INTO `eguide` VALUES ('7', '1505132842367181319.png', '涵盖法学、经济学、史学、文学、理学、工学、教育学、管理学、艺术学等9个学科门类，形成了以教师教育、文理学科为特色，文理管工多学科协调发展的办学格局。', '1505132842369265724.png', ' 学校创办于1958年6月，赣南师范专科学校，1984年升格为本科师范院校，成为省属两所本科师范院校之一，2003年成为硕士学位授予权单位，2009获教育硕士专业学位研究生培养资格。 涵盖法学、经济学、史学、文学、理学、工学、教育学、管理学、艺术学等9个学科门类，形成了以教师教育、文理学科为特色，文理管工多学科协调发展的办学格局。\r\n', '1505132842371239158.jpg', '1505132842372443215.jpg', '赣南师范大学');
INSERT INTO `eguide` VALUES ('8', '1505132912890384134.png', '赣南医学院是江西省唯一独立设置的普通高等本科医学院，坐落在江西南部、京九铁路线上的历史文化名城---赣州市内。', '1505132912892956721.jpg', '江西省唯一独立设置的普通高等本科医学院，坐落在江西南部、京九铁路线上的历史文化名城---赣州市内。中国科学院院士韩济生教授担任名誉院长。学校创办于1941年，先后经历了江西省赣县高级助产职业学校、江西省赣县高级医事职业学校、江西省赣州护士助产学校、江西省赣州卫生学校等时期；1958年8月建立赣南医学专科学校，1988年4月升格为赣南医学院并开始招收本科生。1997年通过教育部本科教学工作合格评估，2007年获教育部普通高等学校本科教学工作水平评估优良成绩。', '1505132912893110284.png', '1505132912894938165.jpg', '赣南医学院');
INSERT INTO `eguide` VALUES ('9', '1505132969805958592.png', '国家开放大学直属教育部，以现代信息技术为支撑，学历教育与非学历教育并举，实施远程开放教育的新型高等学校', '1505132969808387964.png', '国家开放大学是教育部直属的，以现代信息技术为支撑，学历教育与非学历教育并举，实施远程开放教育的新型高等学校。学校在广播电视大学基础上组建，面向全体社会成员，强调优质教育资源的集聚、整合和共享，强调以现代信息技术为支撑，探索现代信息技术与教育的深度融合。', '1505132969809664715.jpg', '1505132969811687413.jpg', '国家开放大学');
INSERT INTO `eguide` VALUES ('10', '1505133022551530653.png', '华南师范大学（South China Normal University），简称“华师”，坐落于南方名城广州市，由中华人民共和国教育部和广东省人民政府共建，入选中国首批“211工程”、“卓越教师培养计划”，为广东省省属重点大学、中国100 所首批联入CERNET和INTERNET网的高等院校之一。', '1505133022553193021.jpg', '华南师范大学（South China Normal University），简称“华师”，坐落于南方名城广州市，由中华人民共和国教育部和广东省人民政府共建，入选中国首批“211工程”、“卓越教师培养计划”，为广东省省属重点大学、中国100 所首批联入CERNET和INTERNET网的高等院校之一。 华南师范大学始建于1933年，前身是当代著名教育家林砺儒先生创建的广东省立勷勤大学师范学院；1982年10月，易名为华南师范大学；2006年，学校通过“十五”“211工程”建设整体验收。2004年，原中共中央总书记、国家主席胡锦涛出席澳门回归五周年庆典期间，称该校是中国数家名牌师范大学之一。', '15051330225556143.png', '1505133022556223997.jpg', '华南师范大学');
INSERT INTO `eguide` VALUES ('11', '1505133091448752445.png', '创建于1979年1月，是经江西省人民政府批准创办的直属高校，主要运用广播、电视、文字教材、音像教材和计算机课件及网络等多种媒体进行现代远程开放教育的新型高等学校', '1505133091452117000.jpg', '创建于1979年1月，是经江西省人民政府批准创办的直属高校，主要运用广播、电视、文字教材、音像教材和计算机课件及网络等多种媒体进行现代远程开放教育的新型高等学校，自办学以来，学校先后开设了60个科类专业，开设课程340多门。今天，江西广播电视大学已形成了具有中国特色的现代远距离教育系统和模式，截止2012年底，全省各类学历教育在校生111976人，其中开放教育89791人，高职教育4354人，网络教育10332人，自考3379人，成人大专1439人，中专教育2681人。在校生规模和年度招生规模位居全国省级电大前列。', '1505133091455790211.png', '1505133091456580000.jpg', '江西广播电视大学');
INSERT INTO `eguide` VALUES ('12', '1505133146773545284.png', '江西科技师范大学坐落于具有“物华天宝、人杰地灵”声誉的历史文化名城——南昌，是我国首批建立的高等职业技术师范院校', '1505133146775502228.png', '江西科技师范大学坐落于具有“物华天宝、人杰地灵”声誉的历史文化名城——南昌，是我国首批建立的高等职业技术师范院校，是教育部重点建设的培养职业教育师资的高等院校，也是江西省唯一一所培养职业教育师资的多科性本科院校，主要培养职教师资、普教师资和应用型专门人才。经过60多年的建设与发展，学校形成了以本科、研究生教育为主体，统筹发展继续教育的多学科、多层次的办学格局。2008年，学校以“优秀”成绩通过教育部本科教学工作水平评估。', '1505133146776768499.png', '1505133146777480319.jpg', '江西科技师范大学');

-- ----------------------------
-- Table structure for homecontent
-- ----------------------------
DROP TABLE IF EXISTS `homecontent`;
CREATE TABLE `homecontent` (
  `hcid` int(11) NOT NULL AUTO_INCREMENT,
  `pictureone` varchar(50) DEFAULT NULL,
  `picturetwo` varchar(50) DEFAULT NULL,
  `picturethree` varchar(50) DEFAULT NULL,
  `qrcodeone` varchar(50) DEFAULT NULL,
  `qrcodetwo` varchar(50) DEFAULT NULL,
  `hcphone` varchar(15) DEFAULT NULL,
  `hcaddress` varchar(70) DEFAULT NULL,
  `interlinkageone` varchar(50) DEFAULT NULL,
  `interlinkagetwo` varchar(50) DEFAULT NULL,
  `interlinkagethree` varchar(50) DEFAULT NULL,
  `interlinkagefour` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hcid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homecontent
-- ----------------------------
INSERT INTO `homecontent` VALUES ('1', '1505177772527808539.jpg', '1505177772529920012.jpg', '1505177772531699806.jpg', '1505178420711182238.jpg', '1505178420714432698.jpg', '0797-8638630', '江西省赣州市章贡区', 'http://www.jxck168.com/loginAction!index.action', 'http://www.jckjpx.webportal.cc/', 'http://www.cjykzx.com/', 'http://112.74.115.92/');

-- ----------------------------
-- Table structure for hotmajor
-- ----------------------------
DROP TABLE IF EXISTS `hotmajor`;
CREATE TABLE `hotmajor` (
  `hmid` int(11) NOT NULL AUTO_INCREMENT,
  `hmtitle` varchar(100) DEFAULT NULL,
  `hmpicture` varchar(50) DEFAULT NULL,
  `hmcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hmid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotmajor
-- ----------------------------
INSERT INTO `hotmajor` VALUES ('5', '教育学', '150530188157391916.jpg', '教育学是一门研究教育现象及其规律的社会科学。它广泛存在于人类生活中。通过对教育现象、教育问题的研究来揭示教育的一般规律。');
INSERT INTO `hotmajor` VALUES ('6', '会计学', '1505301901754850901.jpg', '该专业培养具备管理、经济、法律和会计学等方面的知识和能力，能在企、事业单位及政府部门从事会计实务以及教学、科研方面工作的工商管理学科高级专门人才。 ');
INSERT INTO `hotmajor` VALUES ('7', '土木学', '1505301923651698407.jpg', '土木工程专业培养掌握各类土木工程学科的基本理论和基本知识，能在房屋建筑、地下建筑（含矿井建筑）、道路、隧道、桥梁建筑、水电站、港口及近海结构与设施、给水排水和地基处理等领域从事规划、设计、施工、管理和研究工作的高级工程技术人才。');
INSERT INTO `hotmajor` VALUES ('8', '医学', '1505301946231338769.jpg', ' 医学，是通过科学或技术的手段处理人体的各种疾病或病变的学科。它是生物学的应用学科，分基础医学、临床医学。从解剖层面和分子遗传层面来处理人体疾病的高级科学。它是一个从预防到治疗疾病的系统学科，研究领域大方向包括基础医学、临床医学、法医学、检验医学、预防医学、保健医学、康复医学等。');

-- ----------------------------
-- Table structure for jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES ('1', '1');
INSERT INTO `jurisdiction` VALUES ('2', '2');
INSERT INTO `jurisdiction` VALUES ('3', '3');
INSERT INTO `jurisdiction` VALUES ('4', '4');
INSERT INTO `jurisdiction` VALUES ('5', '5');
INSERT INTO `jurisdiction` VALUES ('6', '6');
INSERT INTO `jurisdiction` VALUES ('7', '7');
INSERT INTO `jurisdiction` VALUES ('8', '8');
INSERT INTO `jurisdiction` VALUES ('9', '9');
INSERT INTO `jurisdiction` VALUES ('10', '10');
INSERT INTO `jurisdiction` VALUES ('11', '11');
INSERT INTO `jurisdiction` VALUES ('12', '12');
INSERT INTO `jurisdiction` VALUES ('13', '13');
INSERT INTO `jurisdiction` VALUES ('14', '14');
INSERT INTO `jurisdiction` VALUES ('15', '15');
INSERT INTO `jurisdiction` VALUES ('16', '16');
INSERT INTO `jurisdiction` VALUES ('17', '17');
INSERT INTO `jurisdiction` VALUES ('18', '18');
INSERT INTO `jurisdiction` VALUES ('19', '19');
INSERT INTO `jurisdiction` VALUES ('20', '20');
INSERT INTO `jurisdiction` VALUES ('21', '21');
INSERT INTO `jurisdiction` VALUES ('22', '22');
INSERT INTO `jurisdiction` VALUES ('23', '23');
INSERT INTO `jurisdiction` VALUES ('24', '24');
INSERT INTO `jurisdiction` VALUES ('25', '25');
INSERT INTO `jurisdiction` VALUES ('26', '26');
INSERT INTO `jurisdiction` VALUES ('27', '27');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(50) DEFAULT NULL,
  `ncontent` varchar(255) DEFAULT NULL,
  `ndate` datetime DEFAULT NULL,
  `nflag` int(11) DEFAULT '0',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('7', '《聚成教育2017年度合作共赢论坛》', '提前预祝聚成教育2017年度合作共赢论坛顺利召开。  2017年5月14日在赣州市章贡区客家大道188号新宏远大酒店三楼（汽车南站对面）正德健康养生管理中心召开。  此次论坛为推动我市教育行业健康、有序、稳定发展，我校特举办聚成教育2017年度合作共赢论坛，共谋教育发展思路。  诚邀各界合作人员莅临座谈！', '2017-09-06 00:00:00', null);
INSERT INTO `notice` VALUES ('8', '会计培训', '会计培训班开始报名啦，2017年3月18日星期六晚上开启第一课！', '2017-09-07 00:00:00', null);
INSERT INTO `notice` VALUES ('9', '2017远程教育开始报名啦', '想提升学历？想升职加薪？想提升自己？聚成远程教育——为您着想！名牌大学任你选，轻松实现你的大学梦。', '2017-09-08 00:00:00', null);
INSERT INTO `notice` VALUES ('10', '江中开学典礼', '通知：定在3月31日，周五酒店进行江中开学典礼，地点：红旗大道聚成学校，参加人员为合作招生教务人员，新生。', '2017-09-09 00:00:00', null);
INSERT INTO `notice` VALUES ('11', 'SSH项目答辩', '招生管理平台项目答辩', '2017-09-21 00:00:00', null);

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `code` varchar(64) NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `seq` tinyint(2) NOT NULL DEFAULT '0',
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '董事会', '赣州市红旗大道55号', '1', 'fi-social-windows', '1', '2017-08-23 14:24:38');
INSERT INTO `organization` VALUES ('2', '财务部', '赣州市红旗大道55号', '2', 'fi-folder', '0', '2017-08-24 14:42:17');
INSERT INTO `organization` VALUES ('6', '开发部', '赣州市红旗大道55号', '4', 'fi-folder', '1', '2017-08-24 14:46:47');

-- ----------------------------
-- Table structure for professionapply
-- ----------------------------
DROP TABLE IF EXISTS `professionapply`;
CREATE TABLE `professionapply` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pstudentno` varchar(20) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `pphone` varchar(20) NOT NULL,
  `pcontent` varchar(20) NOT NULL,
  `cityid` int(11) NOT NULL,
  `countyid` varchar(30) NOT NULL,
  `pdata` datetime NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK_userid_professionapply` (`userid`),
  KEY `FKC2BFDFF2E52FE23B` (`cityid`),
  CONSTRAINT `FKC2BFDFF2E52FE23B` FOREIGN KEY (`cityid`) REFERENCES `city` (`cid`),
  CONSTRAINT `FK_userid_professionapply` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of professionapply
-- ----------------------------
INSERT INTO `professionapply` VALUES ('1', '1', '机器人', '1', '12123123', '职业1', '1', '1', '2017-08-23 14:25:36');

-- ----------------------------
-- Table structure for professionfinance
-- ----------------------------
DROP TABLE IF EXISTS `professionfinance`;
CREATE TABLE `professionfinance` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `tid` int(11) NOT NULL,
  `needmoney` int(11) NOT NULL,
  `practicalmoney` int(11) NOT NULL,
  `fdata` varchar(50) DEFAULT NULL,
  `fway` varchar(20) DEFAULT NULL,
  `fstatu` int(11) NOT NULL,
  `ftest1` int(11) DEFAULT NULL,
  `ftest2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of professionfinance
-- ----------------------------
INSERT INTO `professionfinance` VALUES ('1', '1', '宏大发', '1', '8000', '4000', '2017-9-13 10:13:19', '银行转账', '1', null, null);
INSERT INTO `professionfinance` VALUES ('2', '2', '水手', '2', '8000', '0', null, null, '0', null, null);

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rqq` varchar(12) NOT NULL,
  `rphone` varchar(20) NOT NULL,
  `rcontent` varchar(50) DEFAULT NULL,
  `reffect` varchar(20) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation` VALUES ('1', '790271961', '110', '陈老师', '学籍');
INSERT INTO `relation` VALUES ('2', '88888888', '119', '李老师', '财务');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `seq` tinyint(2) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0', '最高权限', '0');
INSERT INTO `role` VALUES ('2', '聚成管理', '0', '低权限', '0');
INSERT INTO `role` VALUES ('3', '财务管理', '0', '中权限', '0');
INSERT INTO `role` VALUES ('4', '合作老师', '0', '最低权限', '0');
INSERT INTO `role` VALUES ('10', '合作老师1', '0', '最低权限', '0');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` bigint(19) NOT NULL,
  `stitle` varchar(50) DEFAULT NULL,
  `scontent` varchar(200) DEFAULT NULL,
  `sdate` datetime DEFAULT NULL,
  `sfinishdate` datetime DEFAULT NULL,
  `sflag` int(11) DEFAULT '0',
  PRIMARY KEY (`sid`),
  KEY `suserid_fk_user` (`userid`) USING BTREE,
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '1', '敲代码', '做一个项目', '2017-08-23 14:24:38', '2017-09-01 16:38:39', '1');
INSERT INTO `schedule` VALUES ('2', '2', '敲更多代码', '做两个项目', '2017-08-23 14:24:38', '2017-09-01 16:38:34', '1');
INSERT INTO `schedule` VALUES ('5', '1', '吃鸡', '大吉大利 , 今晚吃鸡', '2017-09-10 20:44:07', null, '0');
INSERT INTO `schedule` VALUES ('6', '2', '吃鸡', '大吉大利  今晚吃鸡', '2017-09-12 09:29:02', null, '0');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `shareid` int(11) NOT NULL AUTO_INCREMENT,
  `sharetitle` varchar(255) DEFAULT NULL,
  `sharephoto` varchar(255) DEFAULT NULL,
  `sharecontent` varchar(255) DEFAULT NULL,
  `sharepicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shareid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share
-- ----------------------------
INSERT INTO `share` VALUES ('4', '职业资格证即职业资格证书', '1505306464306623097.jpg', '职业资格证即职业资格证书，是表明劳动者具有从事某一职业所必备的学识和技能的证明。它是劳动者求职、任职、开业的资格凭证，是用人单位招聘、录用劳动者的主要依据，也是境外就业、对外劳务合作人员办理技能水平公证的有效证件。', '1505306464308461588.jpg');

-- ----------------------------
-- Table structure for specialty
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(30) NOT NULL,
  `sort` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialty
-- ----------------------------
INSERT INTO `specialty` VALUES ('1', '土木', '0');
INSERT INTO `specialty` VALUES ('2', '医学', '0');
INSERT INTO `specialty` VALUES ('3', '药学', '0');

-- ----------------------------
-- Table structure for stateapply
-- ----------------------------
DROP TABLE IF EXISTS `stateapply`;
CREATE TABLE `stateapply` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sstudentno` varchar(20) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `idnumber` varchar(20) NOT NULL,
  `sphone` varchar(20) NOT NULL,
  `stype` int(11) NOT NULL DEFAULT '0',
  `acaid` int(11) NOT NULL,
  `specid` int(11) NOT NULL,
  `sgradation` varchar(20) NOT NULL,
  `ssystem` varchar(20) NOT NULL,
  `cityid` int(11) NOT NULL,
  `countyid` varchar(30) NOT NULL,
  `sdata` datetime NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `FK_userid_state` (`userid`),
  KEY `FKF289F17D4CFACC4A` (`specid`),
  KEY `FKF289F17DE52FE23B` (`cityid`),
  KEY `FKF289F17D911B1B7C` (`acaid`),
  CONSTRAINT `FKF289F17D4CFACC4A` FOREIGN KEY (`specid`) REFERENCES `specialty` (`sid`),
  CONSTRAINT `FKF289F17D911B1B7C` FOREIGN KEY (`acaid`) REFERENCES `academy` (`aid`),
  CONSTRAINT `FKF289F17DE52FE23B` FOREIGN KEY (`cityid`) REFERENCES `city` (`cid`),
  CONSTRAINT `FK_userid_state` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stateapply
-- ----------------------------
INSERT INTO `stateapply` VALUES ('1', '1', '王五五', '1', '123123123132', '123123', '0', '1', '1', '高达专', '三年', '2', '10', '2017-08-23 14:25:30');
INSERT INTO `stateapply` VALUES ('2', '2', '赵六', '13', '123456', '123456', '0', '2', '1', '高达专', '两年', '3', '6', '2017-08-30 09:22:49');
INSERT INTO `stateapply` VALUES ('7', '3', '菜鸡明明', '1', '123', '123', '0', '1', '3', '高达本', '两年', '1', '2', '2017-08-31 11:13:55');
INSERT INTO `stateapply` VALUES ('8', '4', '我叫咸鱼明', '2', '123456', '123456', '0', '1', '2', '高达本', '三年', '3', '4', '2017-09-14 15:15:39');

-- ----------------------------
-- Table structure for statefinance
-- ----------------------------
DROP TABLE IF EXISTS `statefinance`;
CREATE TABLE `statefinance` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `schoolid` int(11) NOT NULL,
  `majorid` int(11) NOT NULL,
  `gradation` varchar(30) NOT NULL,
  `tid` int(11) NOT NULL,
  `needmoney` int(11) NOT NULL,
  `practicalmoney` int(11) NOT NULL,
  `fdata` varchar(50) DEFAULT NULL,
  `fway` varchar(20) DEFAULT NULL,
  `fstatu` int(11) NOT NULL,
  `ftest1` int(11) DEFAULT NULL,
  `ftest2` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `FK743F7629B3FB02C8` (`majorid`),
  KEY `FK743F7629628E1531` (`schoolid`),
  CONSTRAINT `FK743F7629628E1531` FOREIGN KEY (`schoolid`) REFERENCES `academy` (`aid`),
  CONSTRAINT `FK743F7629B3FB02C8` FOREIGN KEY (`majorid`) REFERENCES `specialty` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statefinance
-- ----------------------------
INSERT INTO `statefinance` VALUES ('1', '3', '菜鸡明明', '1', '3', '高达本', '1', '10000', '6000', '2017-9-11 21:16:00', '银行转账', '1', null, null);
INSERT INTO `statefinance` VALUES ('2', '4', '我叫咸鱼明', '1', '2', '高达本', '2', '10000', '0', null, null, '0', null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sstudentno` varchar(20) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `userid` bigint(19) NOT NULL,
  `idnumber` varchar(20) DEFAULT NULL,
  `sphone` varchar(11) NOT NULL,
  `scontent` varchar(100) DEFAULT NULL,
  `academyid` varchar(30) DEFAULT NULL,
  `sgradations` varchar(20) DEFAULT NULL,
  `ssystme` varchar(20) DEFAULT NULL,
  `sdate` datetime DEFAULT NULL,
  `stype` int(10) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `userid_fk_uid` (`userid`) USING BTREE,
  KEY `academyid_fk_aid` (`academyid`) USING BTREE,
  KEY `s_studentno` (`sstudentno`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '王小二', '2', '360279199702253237', '1383838438', '计算机', '北大', '专升本', '三年', '2017-08-23 14:24:39', '0', null);
INSERT INTO `student` VALUES ('2', '2', '王小花', '2', '360279199702251313', '1383832222', '艺术', '南大', '专升本', '三年', '2017-08-23 14:24:39', '1', null);

-- ----------------------------
-- Table structure for stufile
-- ----------------------------
DROP TABLE IF EXISTS `stufile`;
CREATE TABLE `stufile` (
  `sfid` int(11) NOT NULL AUTO_INCREMENT,
  `stuid` int(11) DEFAULT NULL,
  `stuname` varchar(50) DEFAULT NULL,
  `sfphoto` varchar(50) DEFAULT NULL,
  `sfvoucher` varchar(50) DEFAULT NULL,
  `sfpaper` varchar(50) DEFAULT NULL,
  `sfdate` datetime DEFAULT NULL,
  PRIMARY KEY (`sfid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stufile
-- ----------------------------
INSERT INTO `stufile` VALUES ('18', '1', '张三疯', '150486086509947606.gif', '1504860865101320589.jpg', '1504860865102502901.jpg', '2017-09-08 16:54:25');
INSERT INTO `stufile` VALUES ('19', '7', '学生7', '1505354711481162279.jpg', '1505354711482321416.jpg', '1505354711483397627.jpg', '2017-09-14 10:05:11');

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `optcontent` varchar(1024) DEFAULT NULL,
  `clientip` varchar(255) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syslog
-- ----------------------------
INSERT INTO `syslog` VALUES ('1', 'admin', '超级管理员', 'xxx', '192.168.4.32', '2017-08-23 14:24:36');
INSERT INTO `syslog` VALUES ('2', '张三', '合作老师', 'xxx', '192.168.2.11', '2017-08-23 14:24:36');
INSERT INTO `syslog` VALUES ('3', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-15 14:25:22');
INSERT INTO `syslog` VALUES ('4', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-15 14:49:45');
INSERT INTO `syslog` VALUES ('5', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-15 15:37:58');
INSERT INTO `syslog` VALUES ('6', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-15 16:29:15');
INSERT INTO `syslog` VALUES ('7', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-16 08:03:09');
INSERT INTO `syslog` VALUES ('8', 'admin', '张三', '鐢ㄦ埛adminip0:0:0:0:0:0:0:1绫诲悕锛�com.edu.action.SignUpAction鏂规硶锛歭ogin', '0:0:0:0:0:0:0:1', '2017-09-18 10:24:05');
INSERT INTO `syslog` VALUES ('9', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-20 20:52:36');
INSERT INTO `syslog` VALUES ('10', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-20 20:52:36');
INSERT INTO `syslog` VALUES ('11', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-20 20:52:38');
INSERT INTO `syslog` VALUES ('12', 'admin', '张三', '用户adminip0:0:0:0:0:0:0:1类名：com.edu.action.SignUpAction方法：login', '0:0:0:0:0:0:0:1', '2017-09-21 08:11:40');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `sex` tinyint(2) NOT NULL DEFAULT '0',
  `age` tinyint(2) DEFAULT '0',
  `phone` varchar(20) DEFAULT NULL,
  `usertype` tinyint(2) NOT NULL DEFAULT '0',
  `status` tinyint(2) NOT NULL DEFAULT '0',
  `organizationid` int(11) NOT NULL DEFAULT '0',
  `createtime` datetime NOT NULL,
  `rid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '张三', '1234', '0', '12', '123', '0', '0', '1', '2017-08-23 14:24:36', '1');
INSERT INTO `user` VALUES ('2', 'test', '李四', '123456', '1', '14', '2222', '0', '0', '2', '2017-08-23 14:24:37', '2');
INSERT INTO `user` VALUES ('12', 'qiu', '秋秋', '123456', '0', '14', '3333', '1', '0', '2', '2017-08-25 08:07:09', '2');
INSERT INTO `user` VALUES ('13', 'min', '明明', '123456', '0', '12', '444', '1', '1', '2', '2017-08-25 10:48:39', '2');
INSERT INTO `user` VALUES ('14', 'nihao', '峰峰', '1234', '0', '19', '12345', '0', '0', '6', '2017-09-04 16:34:00', '4');

-- ----------------------------
-- Table structure for userjurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `userjurisdiction`;
CREATE TABLE `userjurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `jid` int(11) NOT NULL,
  `flag` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userjurisdiction
-- ----------------------------
INSERT INTO `userjurisdiction` VALUES ('1', '1', '1', '0');
INSERT INTO `userjurisdiction` VALUES ('2', '1', '2', '0');
INSERT INTO `userjurisdiction` VALUES ('3', '1', '3', '0');
INSERT INTO `userjurisdiction` VALUES ('4', '1', '4', '0');
INSERT INTO `userjurisdiction` VALUES ('5', '1', '5', '0');
INSERT INTO `userjurisdiction` VALUES ('6', '1', '6', '0');
INSERT INTO `userjurisdiction` VALUES ('7', '1', '7', '0');
INSERT INTO `userjurisdiction` VALUES ('8', '1', '8', '0');
INSERT INTO `userjurisdiction` VALUES ('9', '1', '9', '0');
INSERT INTO `userjurisdiction` VALUES ('10', '1', '10', '0');
INSERT INTO `userjurisdiction` VALUES ('11', '1', '11', '0');
INSERT INTO `userjurisdiction` VALUES ('12', '1', '12', '0');
INSERT INTO `userjurisdiction` VALUES ('13', '1', '13', '0');
INSERT INTO `userjurisdiction` VALUES ('14', '1', '14', '0');
INSERT INTO `userjurisdiction` VALUES ('15', '1', '15', '0');
INSERT INTO `userjurisdiction` VALUES ('16', '1', '16', '0');
INSERT INTO `userjurisdiction` VALUES ('17', '1', '17', '0');
INSERT INTO `userjurisdiction` VALUES ('18', '1', '18', '0');
INSERT INTO `userjurisdiction` VALUES ('19', '1', '19', '0');
INSERT INTO `userjurisdiction` VALUES ('20', '1', '20', '0');
INSERT INTO `userjurisdiction` VALUES ('21', '1', '21', '0');
INSERT INTO `userjurisdiction` VALUES ('22', '1', '22', '0');
INSERT INTO `userjurisdiction` VALUES ('23', '1', '23', '0');
INSERT INTO `userjurisdiction` VALUES ('24', '1', '24', '0');
INSERT INTO `userjurisdiction` VALUES ('25', '1', '25', '0');
INSERT INTO `userjurisdiction` VALUES ('26', '1', '26', '0');
INSERT INTO `userjurisdiction` VALUES ('27', '2', '1', '1');
INSERT INTO `userjurisdiction` VALUES ('28', '2', '2', '1');
INSERT INTO `userjurisdiction` VALUES ('29', '2', '3', '1');
INSERT INTO `userjurisdiction` VALUES ('30', '2', '4', '0');
INSERT INTO `userjurisdiction` VALUES ('31', '2', '5', '0');
INSERT INTO `userjurisdiction` VALUES ('32', '2', '6', '0');
INSERT INTO `userjurisdiction` VALUES ('33', '2', '7', '0');
INSERT INTO `userjurisdiction` VALUES ('34', '2', '8', '0');
INSERT INTO `userjurisdiction` VALUES ('35', '2', '9', '0');
INSERT INTO `userjurisdiction` VALUES ('36', '2', '10', '0');
INSERT INTO `userjurisdiction` VALUES ('37', '2', '11', '0');
INSERT INTO `userjurisdiction` VALUES ('38', '2', '12', '0');
INSERT INTO `userjurisdiction` VALUES ('39', '2', '13', '0');
INSERT INTO `userjurisdiction` VALUES ('40', '2', '14', '0');
INSERT INTO `userjurisdiction` VALUES ('41', '2', '15', '0');
INSERT INTO `userjurisdiction` VALUES ('42', '2', '16', '0');
INSERT INTO `userjurisdiction` VALUES ('43', '2', '17', '0');
INSERT INTO `userjurisdiction` VALUES ('44', '2', '18', '0');
INSERT INTO `userjurisdiction` VALUES ('45', '2', '19', '0');
INSERT INTO `userjurisdiction` VALUES ('46', '2', '20', '0');
INSERT INTO `userjurisdiction` VALUES ('47', '2', '21', '0');
INSERT INTO `userjurisdiction` VALUES ('48', '2', '22', '0');
INSERT INTO `userjurisdiction` VALUES ('49', '2', '23', '0');
INSERT INTO `userjurisdiction` VALUES ('50', '2', '24', '0');
INSERT INTO `userjurisdiction` VALUES ('51', '2', '25', '0');
INSERT INTO `userjurisdiction` VALUES ('52', '2', '26', '1');
INSERT INTO `userjurisdiction` VALUES ('53', '3', '1', '1');
INSERT INTO `userjurisdiction` VALUES ('54', '3', '2', '1');
INSERT INTO `userjurisdiction` VALUES ('55', '3', '3', '1');
INSERT INTO `userjurisdiction` VALUES ('56', '3', '4', '0');
INSERT INTO `userjurisdiction` VALUES ('57', '3', '5', '0');
INSERT INTO `userjurisdiction` VALUES ('58', '3', '6', '0');
INSERT INTO `userjurisdiction` VALUES ('59', '3', '7', '0');
INSERT INTO `userjurisdiction` VALUES ('60', '3', '8', '0');
INSERT INTO `userjurisdiction` VALUES ('61', '3', '9', '0');
INSERT INTO `userjurisdiction` VALUES ('62', '3', '10', '0');
INSERT INTO `userjurisdiction` VALUES ('63', '3', '11', '0');
INSERT INTO `userjurisdiction` VALUES ('64', '3', '12', '0');
INSERT INTO `userjurisdiction` VALUES ('65', '3', '13', '0');
INSERT INTO `userjurisdiction` VALUES ('66', '3', '14', '0');
INSERT INTO `userjurisdiction` VALUES ('67', '3', '15', '0');
INSERT INTO `userjurisdiction` VALUES ('68', '3', '16', '0');
INSERT INTO `userjurisdiction` VALUES ('69', '3', '17', '0');
INSERT INTO `userjurisdiction` VALUES ('70', '3', '18', '0');
INSERT INTO `userjurisdiction` VALUES ('71', '3', '19', '0');
INSERT INTO `userjurisdiction` VALUES ('72', '3', '20', '0');
INSERT INTO `userjurisdiction` VALUES ('73', '3', '21', '0');
INSERT INTO `userjurisdiction` VALUES ('74', '3', '22', '0');
INSERT INTO `userjurisdiction` VALUES ('75', '3', '23', '0');
INSERT INTO `userjurisdiction` VALUES ('76', '3', '24', '0');
INSERT INTO `userjurisdiction` VALUES ('77', '3', '25', '0');
INSERT INTO `userjurisdiction` VALUES ('78', '3', '26', '0');
INSERT INTO `userjurisdiction` VALUES ('79', '4', '1', '1');
INSERT INTO `userjurisdiction` VALUES ('80', '4', '2', '1');
INSERT INTO `userjurisdiction` VALUES ('81', '4', '3', '1');
INSERT INTO `userjurisdiction` VALUES ('82', '4', '4', '0');
INSERT INTO `userjurisdiction` VALUES ('83', '4', '5', '0');
INSERT INTO `userjurisdiction` VALUES ('84', '4', '6', '0');
INSERT INTO `userjurisdiction` VALUES ('85', '4', '7', '0');
INSERT INTO `userjurisdiction` VALUES ('86', '4', '8', '0');
INSERT INTO `userjurisdiction` VALUES ('87', '4', '9', '0');
INSERT INTO `userjurisdiction` VALUES ('88', '4', '10', '0');
INSERT INTO `userjurisdiction` VALUES ('89', '4', '11', '1');
INSERT INTO `userjurisdiction` VALUES ('90', '4', '12', '1');
INSERT INTO `userjurisdiction` VALUES ('91', '4', '13', '1');
INSERT INTO `userjurisdiction` VALUES ('92', '4', '14', '1');
INSERT INTO `userjurisdiction` VALUES ('93', '4', '15', '1');
INSERT INTO `userjurisdiction` VALUES ('94', '4', '16', '1');
INSERT INTO `userjurisdiction` VALUES ('95', '4', '17', '1');
INSERT INTO `userjurisdiction` VALUES ('96', '4', '18', '1');
INSERT INTO `userjurisdiction` VALUES ('97', '4', '19', '1');
INSERT INTO `userjurisdiction` VALUES ('98', '4', '20', '1');
INSERT INTO `userjurisdiction` VALUES ('99', '4', '21', '1');
INSERT INTO `userjurisdiction` VALUES ('100', '4', '22', '1');
INSERT INTO `userjurisdiction` VALUES ('101', '4', '23', '1');
INSERT INTO `userjurisdiction` VALUES ('102', '4', '24', '1');
INSERT INTO `userjurisdiction` VALUES ('103', '4', '25', '1');
INSERT INTO `userjurisdiction` VALUES ('104', '4', '26', '1');
INSERT INTO `userjurisdiction` VALUES ('189', '10', '1', '1');
INSERT INTO `userjurisdiction` VALUES ('190', '10', '2', '1');
INSERT INTO `userjurisdiction` VALUES ('191', '10', '3', '1');
INSERT INTO `userjurisdiction` VALUES ('192', '10', '4', '0');
INSERT INTO `userjurisdiction` VALUES ('193', '10', '5', '0');
INSERT INTO `userjurisdiction` VALUES ('194', '10', '6', '0');
INSERT INTO `userjurisdiction` VALUES ('195', '10', '7', '0');
INSERT INTO `userjurisdiction` VALUES ('196', '10', '8', '0');
INSERT INTO `userjurisdiction` VALUES ('197', '10', '9', '0');
INSERT INTO `userjurisdiction` VALUES ('198', '10', '10', '0');
INSERT INTO `userjurisdiction` VALUES ('199', '10', '11', '1');
INSERT INTO `userjurisdiction` VALUES ('200', '10', '12', '1');
INSERT INTO `userjurisdiction` VALUES ('201', '10', '13', '1');
INSERT INTO `userjurisdiction` VALUES ('202', '10', '14', '1');
INSERT INTO `userjurisdiction` VALUES ('203', '10', '15', '1');
INSERT INTO `userjurisdiction` VALUES ('204', '10', '16', '1');
INSERT INTO `userjurisdiction` VALUES ('205', '10', '17', '1');
INSERT INTO `userjurisdiction` VALUES ('206', '10', '18', '1');
INSERT INTO `userjurisdiction` VALUES ('207', '10', '19', '0');
INSERT INTO `userjurisdiction` VALUES ('208', '10', '20', '0');
INSERT INTO `userjurisdiction` VALUES ('209', '10', '21', '0');
INSERT INTO `userjurisdiction` VALUES ('210', '10', '22', '0');
INSERT INTO `userjurisdiction` VALUES ('211', '10', '23', '0');
INSERT INTO `userjurisdiction` VALUES ('212', '10', '24', '0');
INSERT INTO `userjurisdiction` VALUES ('213', '10', '25', '0');
INSERT INTO `userjurisdiction` VALUES ('214', '10', '26', '1');
INSERT INTO `userjurisdiction` VALUES ('215', '1', '27', '0');
INSERT INTO `userjurisdiction` VALUES ('216', '2', '27', '1');
INSERT INTO `userjurisdiction` VALUES ('217', '3', '27', '0');
INSERT INTO `userjurisdiction` VALUES ('218', '4', '27', '1');
INSERT INTO `userjurisdiction` VALUES ('219', '10', '27', '1');
INSERT INTO `userjurisdiction` VALUES ('220', '12', '1', '1');
INSERT INTO `userjurisdiction` VALUES ('221', '12', '2', '1');
INSERT INTO `userjurisdiction` VALUES ('222', '12', '3', '1');
INSERT INTO `userjurisdiction` VALUES ('223', '12', '4', '0');
INSERT INTO `userjurisdiction` VALUES ('224', '12', '5', '0');
INSERT INTO `userjurisdiction` VALUES ('225', '12', '6', '0');
INSERT INTO `userjurisdiction` VALUES ('226', '12', '7', '0');
INSERT INTO `userjurisdiction` VALUES ('227', '12', '8', '0');
INSERT INTO `userjurisdiction` VALUES ('228', '12', '9', '0');
INSERT INTO `userjurisdiction` VALUES ('229', '12', '10', '0');
INSERT INTO `userjurisdiction` VALUES ('230', '12', '11', '1');
INSERT INTO `userjurisdiction` VALUES ('231', '12', '12', '1');
INSERT INTO `userjurisdiction` VALUES ('232', '12', '13', '1');
INSERT INTO `userjurisdiction` VALUES ('233', '12', '14', '1');
INSERT INTO `userjurisdiction` VALUES ('234', '12', '15', '1');
INSERT INTO `userjurisdiction` VALUES ('235', '12', '16', '1');
INSERT INTO `userjurisdiction` VALUES ('236', '12', '17', '1');
INSERT INTO `userjurisdiction` VALUES ('237', '12', '18', '1');
INSERT INTO `userjurisdiction` VALUES ('238', '12', '19', '0');
INSERT INTO `userjurisdiction` VALUES ('239', '12', '20', '0');
INSERT INTO `userjurisdiction` VALUES ('240', '12', '21', '0');
INSERT INTO `userjurisdiction` VALUES ('241', '12', '22', '0');
INSERT INTO `userjurisdiction` VALUES ('242', '12', '23', '0');
INSERT INTO `userjurisdiction` VALUES ('243', '12', '24', '0');
INSERT INTO `userjurisdiction` VALUES ('244', '12', '25', '0');
INSERT INTO `userjurisdiction` VALUES ('245', '12', '26', '1');
INSERT INTO `userjurisdiction` VALUES ('246', '12', '27', '1');
