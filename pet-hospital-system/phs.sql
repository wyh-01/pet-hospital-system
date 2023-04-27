/*
 Navicat Premium Data Transfer

 Source Server         : RuoYi
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : localhost:3306
 Source Schema         : phs

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 28/04/2023 00:06:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for phs_case
-- ----------------------------
DROP TABLE IF EXISTS `phs_case`;
CREATE TABLE `phs_case`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disease_id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_list` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_case
-- ----------------------------
INSERT INTO `phs_case` VALUES (4, 1, '病例A', '贵宾十五，2岁，雌性。该犬平时主要饲喂犬粮，偶尔吃少量零食。今年未免疫，驱虫。今日食欲下降，精神尚可，最初出现黄色脓性眼分泌物，鼻头干燥。两天前开始频繁的咳嗽，偶有少量白色粘液咳出，粪便软。体温39.5℃，体重3.5kg，心率128次/min、呼吸28次/min。睑结膜潮红，水润度下降，鼻头干燥，有少量黄色鼻液，诱咳反应阳性。目前临床上对于犬瘟热是采用特异性的抗病毒与对症支持疗法相结合的治疗方法。由于未按时免疫的动物以及母源抗体消耗殆尽的幼年动物体内缺少可以抵抗病毒的抗体，或者由于自身免疫力的下降，不足以产生足够的抗体来对抗体内的病毒，所以外源性的抗体补给在治疗过程中显得尤为重要。同时，干扰素，胸腺肽等生物制剂在抗病毒治疗过程中也起到积极的作用。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/59dfe493-b68e-4bfe-bbd0-626455d721b5.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/e9a940f0-3bb7-4934-ab49-3cdd1f35e3b8.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/a4cec965-2f36-4a64-81bf-f5e9ba5d5d0d.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/28/45a21332-5353-4f92-a9fe-cef51bc1071b.mp4');
INSERT INTO `phs_case` VALUES (5, 2, '病例B', '德牧MAX，2月龄，雄性。该犬从外地购买，一周前运回、免疫一针，未驱虫。室内饲养，近日出现频繁的腹泻，颜色暗红，精神不振，食欲尚可。体温38.9℃，体重4.7kg，心率142次/min、呼吸32次/min。睑结膜潮红，听诊呼吸音粗粝，心音整齐。为了控制继发的呼吸道或胃肠道炎症，在未进行药敏实验的前提下，治疗的过程中需加入两种或两种以上的抗生素以增加抗菌谱，进而积极有效的控制炎症发展。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/19/703f2a74-92ab-4263-a041-b1916591a13a.png', 'null');
INSERT INTO `phs_case` VALUES (6, 1, '病例B', '6个月，食欲下降，精神不佳，经常咳嗽并出现大量的白色粘液，粪便呈现稀状。检查发现它的体温为39.8℃，体重下降了约1公斤。眼睛周围有大量的脓性分泌物，结膜充血。鼻涕清澈，但鼻头干燥。听诊时发现有肺部感染的声音，心率和呼吸速度也比正常值快很多。经过进一步检查，诊断为犬瘟热。治疗方面，医生给予了该犬针对犬瘟热病毒的特异性抗病毒药物、抗生素和其他支持性治疗。在治疗的过程中，它需要密切监测体温和其他症状的变化，并根据需要调整治疗方案。经过几天的治疗，它的症状逐渐减轻，食欲和体重也开始恢复。最终，该犬成功康复并回到了它的家庭。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/b0454de9-e0b8-420d-9578-3b44a457ee17.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/f8d5c399-2f05-44a9-a64c-a254ae768e02.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/974ba556-d498-4eee-b2bc-893786e68049.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/fd55d467-9503-4504-aff0-0a4a0731a957.mp4');
INSERT INTO `phs_case` VALUES (8, 5, '病例A', '一只2岁的萨摩耶犬被主人带来诊所，主人报告狗狗已经出现了呕吐、腹泻和食欲不振等症状，已经持续了两天。在体检中，兽医注意到狗狗有轻微的发热和腹部痛。血液检查显示白细胞计数低于正常值，这提示免疫系统已经被某种病原体攻击。\r\n\r\n兽医怀疑这只狗狗可能感染了犬细小病毒（CPV），于是对狗狗进行了一系列的检测。犬细小病毒是一种高度传染性的病毒，可以通过被感染的犬只的排泄物或呼吸道分泌物传播。最终的检测结果证实了兽医的猜测，狗狗确实感染了犬细小病毒。兽医为狗狗提供了支持性治疗，包括给予抗生素和补液，以保持狗狗的身体状况良好。狗狗逐渐恢复了食欲和活力，最终成功地战胜了疾病。该例病例说明了犬细小病毒的症状和治疗方法。如果您的宠物出现类似的症状，应及时带它去兽医诊所接受检查和治疗。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/5827d64f-0219-435a-a72a-fb2f70d82d1b.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/d6798c58-ed92-4a00-8b8e-3d0d9c54b3ef.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/bf8ebac1-927a-4649-a492-f8cbce63d3bc.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/35623c97-c656-4659-bcf4-a641b58d4e90.mp4');
INSERT INTO `phs_case` VALUES (9, 5, '病例B', '一只6个月大的金毛犬被主人带到兽医诊所，因为它已经连续呕吐了两天，没有食欲，而且也没有喝水。狗狗在家里已经表现出明显的懒散和疲倦，似乎很不舒服。在进行体检时，兽医发现这只狗狗的体温升高，并且腹部有压痛。血液检查显示白细胞计数很高，这意味着它的免疫系统正在应对某种病原体的攻击。由于狗狗的症状与犬细小病毒感染相似，兽医立即进行了相关的检测。检测结果确认了狗狗感染了犬细小病毒。为了治疗狗狗，兽医给予了支持性治疗，包括给狗狗静脉注射液体以保持其体液平衡，以及对呕吐和腹泻进行处理。兽医还为狗狗提供了必要的营养和水分，并提供抗生素来控制感染。经过几天的治疗，狗狗逐渐恢复了健康，最终康复出院。这个例子展示了犬细小病毒感染的症状和治疗过程。如果您的宠物出现类似的症状，一定要及时带它到兽医诊所进行检查和治疗，以确保它能够尽快康复。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/64f19a8f-0ed6-4aad-845f-53ae05bd420a.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/f7b922d3-634a-48ff-a1f3-7068dc6da567.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/4451a7c7-34ea-47cf-8c61-07191f8f3ab3.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/dc60d9d1-a828-4c5b-a912-bad3df755400.mp4');
INSERT INTO `phs_case` VALUES (10, 6, '病例A', '一只1岁的哈士奇被主人带到兽医诊所，因为它已经连续两天没有食欲，呕吐和腹泻，并表现出非常懒散和疲倦。在体检时，兽医注意到狗狗的体温升高，心率加快，腹部有压痛。血液检查结果显示狗狗的白细胞计数很高，提示其免疫系统正在应对某种病原体的攻击。\r\n\r\n由于这些症状与犬细小病毒感染相关，兽医立即进行了相关检测。检测结果证实了兽医的怀疑，狗狗确实感染了犬细小病毒。为了治疗狗狗，兽医给予了抗生素，输液以保持其体液平衡，对呕吐和腹泻进行了处理。经过几天的治疗，狗狗逐渐恢复了健康。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/eafabb09-4a70-42de-9ffe-fd66d07efd3e.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/60454c75-8b63-4787-ad47-c1816d4ccf51.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/d7f70461-c282-446c-855d-85290d5edef3.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/c744451f-f2d7-4d98-93a3-f77a3e93b8da.mp4');
INSERT INTO `phs_case` VALUES (11, 6, '病例B', '一只3岁的比格犬被主人带到兽医诊所，因为它最近出现了呕吐、腹泻和食欲不振的症状。狗狗还表现出非常懒散和疲倦。在体检时，兽医发现狗狗的体温升高，腹部有压痛。血液检查结果显示白细胞计数低于正常值，这提示免疫系统已经被某种病原体攻击。\r\n\r\n考虑到这些症状可能是由犬细小病毒引起的，兽医进行了相关检测。检测结果证实了狗狗感染了犬细小病毒。为了治疗狗狗，兽医给予了抗生素和输液以保持其体液平衡。狗狗逐渐恢复了食欲和活力，最终成功地战胜了疾病。\r\n\r\n这些病例强调了犬细小病毒的常见症状，如呕吐、腹泻、食欲不振等，以及有效的治疗方法，如输液、抗生素和支持性治疗。如果您的宠物出现', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/bc7996ac-4ee1-42d4-b7ef-6d53584115a3.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/c7ff90ee-80b5-47a2-a312-614bd726bfee.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/cdb6809d-cc91-4354-9d32-dfb795a39c6a.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/4d78168f-5b7d-47fd-b613-4c062d9d3f29.mp4');
INSERT INTO `phs_case` VALUES (12, 7, '病例A', '一只2岁的贵宾被主人带到兽医诊所，因为它最近出现了咳嗽、打喷嚏和食欲不振的症状。狗狗还表现出非常懒散和疲倦。在体检时，兽医发现狗狗的体温轻微升高，但其他生理指标正常。检查狗狗的喉咙和肺部，发现它的喉咙红肿，肺部也有轻微的炎症。\r\n\r\n考虑到这些症状可能是由犬冠状病毒引起的，兽医进行了相关检测。检测结果证实了狗狗感染了犬冠状病毒。为了治疗狗狗，兽医给予了支持性治疗，包括保持其体液平衡，给予镇痛药和抗生素以预防继发感染。经过几天的治疗，狗狗逐渐恢复了健康。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/90de0bea-b49e-4cb6-8b96-ad8026906aa6.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/e92db635-d56a-410d-b1ba-31a861a31703.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/cc30b2a9-f3ba-4506-b5bc-6820fdeba02d.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/4c9027d6-5f4b-4742-8187-af11fe119186.mp4');
INSERT INTO `phs_case` VALUES (13, 7, '病例B', '一只4岁的黄金猎犬被主人带到兽医诊所，因为它出现了咳嗽、打喷嚏和流鼻涕的症状。狗狗还表现出食欲不振和口干舌燥的症状。在体检时，兽医发现狗狗的体温略微升高，肺部有轻微的炎症。血液检查结果显示白细胞计数正常。\r\n\r\n考虑到这些症状可能是由犬冠状病毒引起的，兽医进行了相关检测。检测结果证实了狗狗感染了犬冠状病毒。为了治疗狗狗，兽医给予了支持性治疗，包括输液以保持其体液平衡和抗生素以预防继发感染。狗狗逐渐恢复了健康，咳嗽和打喷嚏的症状也得到了缓解。', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/074c3057-9f57-4593-b06a-6e9009e719ea.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/3fd56079-35ca-4267-bcd7-7996cb240862.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/33c1ebdf-81f2-4d17-90c1-7c4dc3b997eb.png', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/657c4059-48c3-4069-8878-4bb419a5be97.mp4');

-- ----------------------------
-- Table structure for phs_disease
-- ----------------------------
DROP TABLE IF EXISTS `phs_disease`;
CREATE TABLE `phs_disease`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kind_id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_disease
-- ----------------------------
INSERT INTO `phs_disease` VALUES (1, 1, '犬瘟热', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/6669a7a4-1ab0-44ba-84d8-771ae01cee05.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/b2ae1415-c15c-4f45-b49b-99e602731bd8.png', '犬瘟热是由犬瘟热病毒引起的一种高度接触性传染病，传染性强，死亡率可高达80%以上。犬瘟热症状初期狗的体温高达39．5～41摄氏度，食欲不振、精神沉郁、眼鼻流出水样分泌物、打喷嚏、有腹泻。在以后2～14天内再次出现体温升高，咳嗽，有脓性鼻涕、脓性眼屎这时候已经是犬瘟中期了。');
INSERT INTO `phs_disease` VALUES (2, 3, '口炎', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/4226401d-3d95-409c-8ffe-20e5370aafb3.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/92fe09c6-2a12-45de-8dd0-3af9e4c8aeb7.png', '口炎（Stomatitis）是指口腔内任何部位的黏膜炎症。临床上常指代广泛、慢性、进展性的口腔黏膜炎症。严重的口炎可导致患猫进食困难、精神状态改变、体重减轻，严重影响猫咪的生活质量。口炎的病理过程是一种复杂、慢性且极具破坏力的增生性或溃疡性炎症过程。口炎的发病机制尚未研究透彻，结合当前的研究结果，部分研究人员认为该病是由免疫因素和感染因素共同作用所致。');
INSERT INTO `phs_disease` VALUES (3, 2, '蛔虫病', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/34c7bc19-fa66-442c-a723-c3fbc73f1929.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/df4c4bd7-610b-4d64-ba40-70f3d41527da.png', '犬蛔虫病是由侵入犬小肠和胃中的蛔虫所引起的一种寄生虫病。寄生的蛔虫由两种蛔虫组成，分别为犬弓首蛔虫隶属于弓首科弓首属和狮弓蛔虫隶属于蛔科弓蛔属。在我国的大部分地区都存在。其主要是侵入两个月左右的幼犬导致其生长发育受到阻碍，严重病例还可导致死亡，它还能引起犬的肠套叠·。');
INSERT INTO `phs_disease` VALUES (4, 4, '脱毛症', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/a8bfb7a3-1634-4885-8024-e25b03fc14d9.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/ea0a8d1f-c80c-447d-9ab5-d81de16d8adc.png', '犬脱毛症，又称秃毛症、无毛症或稀毛症，是指局部或全身被毛脱落的总称。脱毛症早期变化为色素沉着、多皮屑、被毛稀疏等，随后出现脱毛症，对称地分布在犬体的腹肋、胸股部。');
INSERT INTO `phs_disease` VALUES (5, 1, '犬细小病毒', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/5f0fd964-f54f-415b-aee4-d6b6588d52f8.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/c4c8fe26-dce7-4cf3-bca3-0af37b9a2aed.png', '犬细小病（CPV）毒病是由犬细小病毒感染幼犬所引起的一种急性传染病。临床上有两种表现型，出血性特征；心肌炎型则以突然死亡为特征。无论哪种类型的临床表现，均以发病率高、死亡率高和传染性强为特点。');
INSERT INTO `phs_disease` VALUES (6, 1, '犬传染性肝炎', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/7d002f69-94f6-423d-b736-ff2432a2547f.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/2317bc67-d9fa-4db7-ab94-314a0aa66780.png', '犬传染性肝炎（Infectious canine hepatitis），二类传染病，主要发生在1岁以内的幼犬，成年犬很少发生且多为隐性感染，即使发病也多能耐过。病犬和带毒犬是主要传染源。病犬的分泌物、排泄物均含有病毒，康复带毒犬可自尿中长时间排毒。该病主要经消化道感染，胎盘感染也属可能。呼吸型病例可经呼吸道感染。体外寄生虫可成为传播媒介。本病发生无明显季节性，以冬季多发，幼犬的发病率和病死率均较高。');
INSERT INTO `phs_disease` VALUES (7, 1, '犬冠状病毒', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/8dff74b2-c913-41d1-a767-28c9b7619425.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/de5cb851-2ad9-49f8-9a39-41358ae56210.png', '犬冠状病毒为单股正链RNA病毒，有6～7种多肽，其中4种是糖肽，不含RNA聚合酶及神经氨酸酶。犬冠状病毒(canine coronavirus，CCV)是1种严重危害养犬业、经济动物养殖业和野生动物保护的病毒性传染病病源 [1] 。可使犬发生程度不同的胃肠炎症状，特征有频繁呕吐、腹泻、沉郁、厌食等症状。本病一年四季均可发生，以冬季多发，病犬是主要的传染原，犬可通过呼吸道、消化道、粪便及污染物传染。该病一但发生，同窝犬同室犬很难控制均可造成感染。该病经常和犬细小病毒，轮状病毒及其它胃肠道疾病混合感染。幼犬死亡率较高。');
INSERT INTO `phs_disease` VALUES (8, 3, '肠炎', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/71d73585-b748-45a3-9f6f-1757e0161def.png&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/bee4dedc-0950-4f4e-945e-4c5b07357adb.png', '炎性肠病（inflammation bowel disease，IBD）是一组发病机理和病因尚未明确的以肠道黏膜炎症为特点的慢性疾病，常见于中老年猫。IBD可根据肠道发病的区域及主要的炎性细胞浸润类型分为淋巴细胞-浆细胞性、嗜酸性细胞、肉芽肿性、化脓性（中性粒细胞性）以及组织细胞性IBD。其中最常见的是淋巴细胞-浆细胞性。关于猫IBD病因和病理过程的研究尚未完善，目前的研究显示，其发病机制与多因素相关，包括遗传、肠道微生物环境、免疫应答、继发性钴胺素缺乏等。');
INSERT INTO `phs_disease` VALUES (9, 1, '猫瘟热', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/f1a9b9bc-f1de-4945-9638-57cfc4975732.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/5b3e0284-cc57-4eae-8d29-1ac7e33bf705.jpg', '猫瘟热是一种由病毒引起的严重宠物传染病，可导致猫的消化系统、呼吸系统、神经系统和免疫系统受损。猫瘟热的症状包括呕吐、腹泻、高烧、流口水、眼病、皮肤病等。由于该病毒易感染其他猫，因此需要及时隔离患病的猫并进行医疗治疗。');
INSERT INTO `phs_disease` VALUES (10, 1, '犬狂犬病', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/8c52982b-0293-41cb-b461-631d8814c952.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/485f68e1-33af-4d87-bdac-f2811f59f4d8.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/e19cf245-f3b0-46d5-9f36-ed25f4be485e.jpg', '这是一种致命的狗传染病，由一种病毒引起，症状包括发热、口渴、惊厥、咬人等，可以通过。');
INSERT INTO `phs_disease` VALUES (11, 1, '猫钩端螺旋体病', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/40093365-1e01-4577-bf27-e82edff7b975.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/55586f97-2521-4a29-bddf-52be71c24f49.jpg', '这是一种猫传染病，由一种螺旋体引起，症状包括发热、呕吐、腹泻等，可以通过注意卫生和疫苗预防。');
INSERT INTO `phs_disease` VALUES (12, 1, '猫病毒性鼻气管炎', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/26990a14-4a7a-4d75-a1af-583aacb3f628.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/e16fcf2c-197f-4ace-a6eb-482a18a0e05a.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/e4f6c36b-3286-4123-b03c-56a263669455.jpg', '这是一种常见的猫传染病，由一种病毒引起，症状包括打喷嚏、流涕、眼部发炎等，可以通过疫苗预防。');
INSERT INTO `phs_disease` VALUES (13, 1, '犬流行性感冒', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/b86b063c-c1e8-4bac-aada-00f92f44a7a1.jpg&&http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/a266c0d0-9ddc-4fa0-bfa9-a1a0382cfc55.jpg', '这是一种狗传染病，由一种病毒引起，症状包括发热、咳嗽、打喷嚏等，可以通过疫苗预防。');

-- ----------------------------
-- Table structure for phs_disease_kind
-- ----------------------------
DROP TABLE IF EXISTS `phs_disease_kind`;
CREATE TABLE `phs_disease_kind`  (
  `id` int(11) NOT NULL,
  `kind_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_disease_kind
-- ----------------------------
INSERT INTO `phs_disease_kind` VALUES (1, '传染病');
INSERT INTO `phs_disease_kind` VALUES (2, '寄生虫病');
INSERT INTO `phs_disease_kind` VALUES (3, '内科病例');
INSERT INTO `phs_disease_kind` VALUES (4, '其他病例');

-- ----------------------------
-- Table structure for phs_job
-- ----------------------------
DROP TABLE IF EXISTS `phs_job`;
CREATE TABLE `phs_job`  (
  `id` int(11) NOT NULL,
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_job
-- ----------------------------
INSERT INTO `phs_job` VALUES (1, '医师');
INSERT INTO `phs_job` VALUES (2, '助理');
INSERT INTO `phs_job` VALUES (3, '前台');

-- ----------------------------
-- Table structure for phs_quiz
-- ----------------------------
DROP TABLE IF EXISTS `phs_quiz`;
CREATE TABLE `phs_quiz`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disease_id` int(11) NOT NULL,
  `question` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `choice_list` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_quiz
-- ----------------------------
INSERT INTO `phs_quiz` VALUES (1, 1, '下列不属于《中华人民共和国动物防疫法》所称动物疫病的是（）', '禽霍乱&&白肌病&&禽结合病&&犬瘟热', 'A');
INSERT INTO `phs_quiz` VALUES (2, 1, '病犬在康复期出现角膜混浊的常见传染病是（）', '犬瘟热&&犬传染性肝炎&&犬冠状病毒性腹泻&&禽霍乱', 'B');
INSERT INTO `phs_quiz` VALUES (3, 1, '犬猫可视黏膜检查的主要部位是（）', '眼结膜&&鼻腔黏膜&&口腔黏膜&&直肠黏膜', 'C');
INSERT INTO `phs_quiz` VALUES (4, 1, '口炎的症状不包括（）', '大量流涎&&咀嚼障碍&&吞咽障碍&&采食缓慢', 'C');
INSERT INTO `phs_quiz` VALUES (5, 1, '测量犬猫体温的主要部位是（）', '皮肤&&口腔&&腋下&&直肠', 'D');
INSERT INTO `phs_quiz` VALUES (6, 1, '腊肠犬，10岁，头颈僵直，耳竖起，鼻尖抵地，运步小心，触诊颈部敏感。该犬最可能患有（）', '肱骨骨折&&肘关节炎&&犬瘟热&&桡神经麻痹', 'D');
INSERT INTO `phs_quiz` VALUES (7, 1, '母犬，10岁，多食、多饮、多尿，体重减轻，血糖浓度为10mmol/L.有效的治疗药物是（）', '肌苷&&犬瘟热&&胰岛素&&干扰素', 'C');
INSERT INTO `phs_quiz` VALUES (8, 1, '犬，排粪困难，里急后重，甩尾，擦舔肛门，挤压其肛门疼痛并流出黑灰色恶臭物。该病是（）', '肛门囊炎&&犬瘟热&&犬传染性肝&&犬冠状病毒性腹泻', 'A');
INSERT INTO `phs_quiz` VALUES (9, 1, '北京犬，发病1周，包皮肿胀，包皮口污秽不洁、流出脓样腥臭液体；翻开包皮囊，见红肿、溃疡病变。该病是（）', '包皮囊炎&&犬瘟热&&前列腺炎&&犬传染性肝', 'A');
INSERT INTO `phs_quiz` VALUES (10, 1, '犬，饮水量增加，皮肤增厚，弹性降低，色素沉着，躯干部对称性脱毛。X线检查显示骨质疏松。该犬内分泌异常的激素最可能是（）', '甲状腺素&&糖皮质素&&胰岛素&&干扰素', 'A');
INSERT INTO `phs_quiz` VALUES (11, 1, '从猫粪中排出的弓形虫发育阶段是（）', '包囊&&卵囊&&劣殖子&&配子体', 'D');
INSERT INTO `phs_quiz` VALUES (12, 1, '预防伊氏锥虫病最实用的措施为（）', '疫苗免疫&&药物预防&&淘汰病畜&&消灭媒介昆虫', 'C');
INSERT INTO `phs_quiz` VALUES (13, 1, '狗蠕形螨主要寄生在（）', '毛囊和皮脂腺&&表皮&&咬肌&&肝脏', 'A');
INSERT INTO `phs_quiz` VALUES (14, 1, '复孔绦虫病是由于犬、猫类舔被毛时含有跳（）蚤或虱类而被感染。', '囊尾蚴&&尾蚴&&似囊尾蚴&&雷蚴', 'A');
INSERT INTO `phs_quiz` VALUES (15, 1, '犬传染性肝炎根据临床症状和进过可分为（）种。', '两种&&三种&&四种&&五种', 'A');
INSERT INTO `phs_quiz` VALUES (16, 1, '螨虫属于不完全变态。发育过程包括（）个阶段。', '2&&3&&4&&5', 'D');
INSERT INTO `phs_quiz` VALUES (17, 1, '犬猫的螨虫病包括（）种。（）', '2&&3&&4&&5', 'C');
INSERT INTO `phs_quiz` VALUES (18, 1, '狗蠕形螨主要寄生在（）', '2&&3&&4&&5', 'A');
INSERT INTO `phs_quiz` VALUES (19, 1, '根据骨折部位可划分（）种骨折。', '2&&3&&4&&5', 'A');
INSERT INTO `phs_quiz` VALUES (20, 1, '难产的病因不包括（）', '母兽产道狭窄&&母兽分娩不足&&医师技术&&胎儿异常', 'A');

-- ----------------------------
-- Table structure for phs_user
-- ----------------------------
DROP TABLE IF EXISTS `phs_user`;
CREATE TABLE `phs_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `role` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_user
-- ----------------------------
INSERT INTO `phs_user` VALUES (1, 'chris', 'xQvE78Z90e/vh0+2ALXmzA==', 1);
INSERT INTO `phs_user` VALUES (2, 'liu', 'zVknBgvQcYuXihYtR+U2og==', 1);
INSERT INTO `phs_user` VALUES (3, 'zhang', 'XLk37pbszdp+wS1CFDCOgw==', 2);
INSERT INTO `phs_user` VALUES (4, 'Sherry', 'zVknBgvQcYuXihYtR+U2og==', 2);
INSERT INTO `phs_user` VALUES (5, 'coco', 'f6AWmcWW7raqa6C3yvbIyw==', 2);
INSERT INTO `phs_user` VALUES (6, 'wang', 'xQvE78Z90e/vh0+2ALXmzA==', 2);
INSERT INTO `phs_user` VALUES (7, 'chen', 'xQvE78Z90e/vh0+2ALXmzA==', 2);
INSERT INTO `phs_user` VALUES (8, 'fu', 'xQvE78Z90e/vh0+2ALXmzA==', 2);
INSERT INTO `phs_user` VALUES (9, 'jiang', 'xQvE78Z90e/vh0+2ALXmzA==', 2);
INSERT INTO `phs_user` VALUES (10, 'test', 'FfolVLBcoZeXjW2GVpKwsg==', 2);

-- ----------------------------
-- Table structure for phs_work
-- ----------------------------
DROP TABLE IF EXISTS `phs_work`;
CREATE TABLE `phs_work`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video_url` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_work
-- ----------------------------
INSERT INTO `phs_work` VALUES (1, 1, '查房', '带领实习医师对病员进行检查，诊断及治疗，书写医嘱，并检查医嘱执行情况，每日巡视病人至少2次，对危重症病人应多次巡视并做好记录。', '诊室', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/c7798b00-d43f-4983-b0c2-ed2c0809e820.mp4');
INSERT INTO `phs_work` VALUES (2, 1, '书写病例', '书写病历(第一年写大病历，以后写入院录)应于病人入院24小时内完成。及时检查和修改实习医师的病历记录、病程录及其他各项记录，及时完成出院病案小结并将病案整理编号交上级医师审查。', '诊室', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/d8c236a2-b304-465a-a583-e2f920a0b9ca.mp4');
INSERT INTO `phs_work` VALUES (3, 2, '抢救宠物', '参加科室内的抢救工作要求，在抢救宠物过程中，做到处理得当，抢救及时，及时完成病程记录。', '前台', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/1c328116-3f4f-45a5-8c22-d276ecd23dc2.mp4');
INSERT INTO `phs_work` VALUES (9, 3, '接待', '接待顾客引导服务。', '前台', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/d862d031-44bc-4b89-bd12-dc0adfbc55a7.mp4');
INSERT INTO `phs_work` VALUES (10, 2, '外科检查', '检查宠物五官及口腔内部、被毛健康状况、皮肤健康状况。', '检查室', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/27/324be6de-67d7-4a75-aea5-229e5d6a462b.mp4');
INSERT INTO `phs_work` VALUES (11, 3, '结账', '清算宠物就医的相关费用。', '前台', 'http://pet-hospital-system.oss-cn-shanghai.aliyuncs.com/files/2023/04/28/6df02239-8631-4011-83b6-4cbd0f6aae59.mp4');

SET FOREIGN_KEY_CHECKS = 1;
