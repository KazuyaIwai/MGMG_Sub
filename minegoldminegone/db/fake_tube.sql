use `minegoldminegone`;

-- FakeTubeシステム定数テーブル
CREATE TABLE IF NOT EXISTS `ft_system_property` (
  `propertiy_name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `contents` LONGTEXT NOT NULL,
PRIMARY KEY (`propertiy_name`)
);

-- 動画保存テーブル
CREATE TABLE IF NOT EXISTS `ft_video` (
  `video_id` INT NOT NULL AUTO_INCREMENT,
  `v_id` VARCHAR(32) NOT NULL,
  `title` LONGTEXT NULL, -- 動画タイトル
  `thumbnail_image` LONGTEXT NULL, -- サムネイル画像
  `thumbnail_hover` LONGTEXT NULL, -- hoverサムネイル画像
  `video_link` LONGTEXT NOT NULL, -- 動画リンク
  `channel_id` VARCHAR(255) NOT NULL, -- 動画チャンネルID 
  `description` LONGTEXT NOT NULL DEFAULT '', -- 動画詳細
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
PRIMARY KEY (`video_id`),
UNIQUE INDEX `v_id_index` (`v_id` ASC)
);

-- 登録チャンネル
CREATE TABLE IF NOT EXISTS `ft_subscribed_channel` (
  `channel_id` VARCHAR(255) NOT NULL,
  `channel_name` LONGTEXT NULL, -- 登録チャンネル名
  `channel_icon` LONGTEXT NULL, -- 登録チャンネルアイコン
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
PRIMARY KEY (`channel_id`)
);

-- 動画視聴統計データ
CREATE TABLE IF NOT EXISTS `ft_video_summary` (
  `video_id` INT NOT NULL ,
  `views` BIGINT(10) NOT NULL -- 視聴回数
PRIMARY KEY (`video_id`)
);

-- いいね悪いね評価
CREATE TABLE `ft_rating_video` (
  `v_id` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `evaluate` TINYINT(1) NULL, -- いいね：1 悪いね：0 評価なし：null
PRIMARY KEY (`v_id`, `user_id`)
);

-- ユーザー登録チャンネル
CREATE TABLE IF NOT EXISTS `ft_user_subscribed_channel` (
  `user_id` VARCHAR(45) NOT NULL,
  `channel_id` VARCHAR(255) NOT NULL,
PRIMARY KEY (`user_id`, `channel_id`)
);

-- 動画コメント保存
CREATE TABLE `ft_video_comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `v_id` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `comment` VARCHAR(1023) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
);

-- FTユーザー
CREATE TABLE `ft_user` (
  `user_id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `avatar_icon` VARCHAR(255) NULL,
PRIMARY KEY (`user_id`)
);

-- コメントサマリー
CREATE TABLE `ft_video_comment_summary` (
  `v_id` VARCHAR(45) NULL,
  `comment_id` INT(11) NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `evaluate` TINYINT(1) NULL DEFAULT NULL,
PRIMARY KEY (`comment_id`, `user_id`));

-- 検索履歴
CREATE TABLE`ft_search_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `search_text` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT NULL,
PRIMARY KEY (`id`));


-- テストデータ ---------------------------------------------------------------------------
-- 定数テーブル
INSERT INTO `ft_system_property` 
(`propertiy_name`, `description`, `contents`) 
VALUES 
('EMVIROMENT', '環境タイプ', 'develop'),
('VIDEO_DIR', '動画ファイル保存パス', '/Users/Shared/myApp/minegoldminegone/src/main/resources/static/vod/ft_video/'),
('CHANNEL_DIR', '登録チャンネルアイコン保存パス', '/Users/Shared/myApp/minegoldminegone/src/main/resources/static/vod/ft_channel/')
('USER_DIR', 'ユーザー情報保存パス', '/Users/Shared/myApp/minegoldminegone/src/main/resources/static/vod/ft_user/')
;

-- 登録チャンネル
INSERT INTO `ft_subscribed_channel` 
(`channel_id`, `channel_name`, `channel_icon`) 
VALUES 
('fox-channel', 'きつねさんチャンネル', 'きつねさん.jpg'),
('patapata_dog_channel', 'ぱたぱた犬さんチャンネル', 'ぱたぱた犬さん.jpg'),
('pen_and_cat_channel', 'ペンとねこさんチャンネル', 'ペンとねこさん.jpg')
;

/* 画像サンプル用
INSERT INTO `ft_video` 
(`video_id`, `v_id`, `title`, `thumbnail_image`, `video_link`, `channel_id`) 
VALUES 
(1,  'XniwCLur', 'テスト動画01', '/300/200?random=1', '/300/200', 'fox-channel'),
(2,  'BNXKzZVL', 'テスト動画02', '/300/200?random=2', '/300/200', 'fox-channel'),
(3,  'KzYDxTcP', 'テスト動画03', '/300/200?random=3', '/300/200', 'fox-channel'),
(4,  'FEDhjpke', 'テスト動画04', '/300/200?random=4', '/300/200', 'patapata_dog_channel'),
(5,  'yRwWemXV', 'テスト動画05', '/300/200?random=5', '/300/200', 'patapata_dog_channel'),
(6,  'pcDfiJpZ', 'テスト動画06', '/300/200?random=6', '/300/200', 'patapata_dog_channel'),
(7,  'MGDPUcCw', 'テスト動画07', '/300/200?random=7', '/300/200', 'pen_and_cat_channel'),
(8,  'FsdYeyDA', 'テスト動画08', '/300/200?random=8', '/300/200', 'pen_and_cat_channel'),
(9,  'CtbZBywt', 'テスト動画09', '/300/200?random=9', '/300/200', 'pen_and_cat_channel'),
(10, 'sUiQcNEJ', 'テスト動画10', '/300/200?random=10', '/300/200', 'fox-channel'),
(11, 'eySyVDPe', 'テスト動画11', '/300/200?random=11', '/300/200', 'fox-channel'),
(12, 'Z_aSmNbN', 'テスト動画12', '/300/200?random=12', '/300/200', 'fox-channel'),
(13, 'JdQerkyp', 'テスト動画11', '/300/200?random=13', '/300/200', 'patapata_dog_channel'),
(14, 'ejWruRun', 'テスト動画12', '/300/200?random=14', '/300/200', 'patapata_dog_channel'),
(15, 'aXGbtWdF', 'テスト動画13', '/300/200?random=15', '/300/200', 'patapata_dog_channel'),
(16, 'SRfUTHfz', 'テスト動画14', '/300/200?random=16', '/300/200', 'pen_and_cat_channel'),
(17, 'eyWXPjMm', 'テスト動画15', '/300/200?random=17', '/300/200', 'pen_and_cat_channel'),
(18, 'TfVEnnSB', 'テスト動画16', '/300/200?random=18', '/300/200', 'pen_and_cat_channel')
;
*/

REPLACE INTO `ft_video` 
(`video_id`, `v_id`, `title`, `thumbnail_image`, `video_link`, `channel_id`) 
VALUES 
(1,  'XniwCLur', 'テスト動画01', '1-XniwCLur.gif', '1-XniwCLur.m3u8', 'fox-channel'),
(2,  'BNXKzZVL', 'テスト動画02', '2-BNXKzZVL.gif', '2-BNXKzZVL.m3u8', 'patapata_dog_channel'),
(3,  'KzYDxTcP', 'テスト動画03', '3-KzYDxTcP.gif', '3-KzYDxTcP.m3u8', 'pen_and_cat_channel'),
(4,  'FEDhjpke', 'テスト動画04', '4-FEDhjpke.gif', '4-FEDhjpke.m3u8', 'fox-channel'),
(5,  'yRwWemXV', 'テスト動画05', '5-yRwWemXV.gif', '5-yRwWemXV.m3u8', 'patapata_dog_channel'),
(6,  'pcDfiJpZ', 'テスト動画06', '6-pcDfiJpZ.gif', '6-pcDfiJpZ.m3u8', 'pen_and_cat_channel'),
(7,  'MGDPUcCw', 'テスト動画07', '7-MGDPUcCw.gif', '7-MGDPUcCw.m3u8', 'fox-channel')
;

INSERT INTO `ft_rating_video` 
(`video_id`, `user_id`, `evaluate`) 
VALUES 
('1', 'admin', '1'),
('2', 'admin', '0'),
('3', 'admin', '1'),
('4', 'admin', '0'),
('5', 'admin', '1'),
('6', 'admin', NULL)
;


INSERT INTO 
`ft_user_subscribed_channel` 
(`user_id`, `channel_id`) 
VALUES 
('admin', 'fox-channel'),
('test_user1', 'fox-channel')
;


INSERT INTO `ft_user` 
(`user_id`, `name`) 
VALUES 
('admin', 'PN.MH'),
('test_user1', 'ビオレパパ'),
('test_user2', 'ミニ弁当'),
('test_user3', 'gaw'),
('test_user4', 'お寿司'),
('test_user5', 'Koara Alcool'),
('test_user6', 'ひがし'),
('test_user7', 'Yまる'),
('test_user8', 'サピトラ猫'),
('test_user9', 'くましろ')
;
