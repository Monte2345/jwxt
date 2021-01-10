-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2021-01-10 10:09:13
-- 服务器版本： 5.7.26
-- PHP 版本： 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `jwxt`
--

-- --------------------------------------------------------

--
-- 替换视图以便查看 `class_schedule`
-- （参见下面的实际视图）
--
CREATE TABLE `class_schedule` (
`gno` int(11)
,`tno` int(11)
,`cno` int(11)
,`type` varchar(20)
,`credit` tinyint(4)
);

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL COMMENT '课程id',
  `cno` int(11) NOT NULL COMMENT '课程号',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程名',
  `credit` tinyint(4) NOT NULL COMMENT '学分',
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程类型（选修、必修）',
  `status` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程状态',
  `class_hours` tinyint(5) NOT NULL COMMENT '学时'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`id`, `cno`, `name`, `credit`, `type`, `status`, `class_hours`) VALUES
(1, 131800701, '高级英语', 2, '专业选修', '选课', 32),
(2, 180600032, 'IT项目管理', 2, '专业选修', '选课', 32),
(3, 180600037, '嵌入式系统', 3, '专业选修', '选课', 48),
(4, 180600065, '自然语言处理', 2, '专业选修', '选课', 32),
(5, 180600075, '机器人导论', 3, '专业选修', '选课', 48),
(6, 180600078, '高级数学', 4, '专业必修', '选课', 64),
(7, 180600068, '计算机视觉与模式识别', 3, '专业必修', '选课', 48);

-- --------------------------------------------------------

--
-- 表的结构 `course_class`
--

CREATE TABLE `course_class` (
  `id` int(11) NOT NULL COMMENT '课程安排id',
  `cno` int(11) NOT NULL COMMENT '课程号',
  `curricula_variable` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '教学班号',
  `time_period` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程安排时间段',
  `capacity` int(11) NOT NULL COMMENT '课程容量',
  `enrollment` int(11) NOT NULL COMMENT '报名人数'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `course_class`
--

INSERT INTO `course_class` (`id`, `cno`, `curricula_variable`, `time_period`, `capacity`, `enrollment`) VALUES
(35, 180600037, '180600037-2', 'Fri|5-6', 100, 0),
(36, 180600037, '180600037-1', 'Fri|9-11', 100, 0),
(34, 180600032, '180600032-2', 'Fri|1-2', 100, 0),
(33, 180600068, '180600068-2', 'Thu|9-11', 100, 0),
(32, 180600075, '180600075-1', 'Thu|7-8', 100, 0),
(31, 131800701, '131800701-2', 'Thu|5-6', 100, 0),
(30, 131800701, '131800701-1', 'Thu|3-4', 100, 0),
(29, 180600078, '180600078-1', 'Thu.Wed|3-4.1-2', 100, 0),
(28, 180600068, '180600068-1', 'Wed|1-2', 100, 0),
(27, 180600075, '180600075-2', 'Tue|7-8', 100, 0),
(26, 180600032, '180600032-1', 'Tue|5-6', 100, 0),
(25, 180600065, '180600065-2', 'Mon|7-8', 100, 0),
(24, 180600065, '180600065-1', 'Mon|5-6', 100, 0),
(23, 180600078, '180600078-2', 'Tue.Mon|1-2.3-4', 100, 0);

-- --------------------------------------------------------

--
-- 表的结构 `course_group`
--

CREATE TABLE `course_group` (
  `id` int(11) NOT NULL COMMENT '课程组id',
  `gno` int(11) NOT NULL COMMENT '课程组号',
  `cno` int(11) NOT NULL COMMENT '课程号',
  `tno` int(11) NOT NULL COMMENT '课程负责人的教工号'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `course_group`
--

INSERT INTO `course_group` (`id`, `gno`, `cno`, `tno`) VALUES
(1, 1806, 131800701, 20210102),
(2, 1807, 180600032, 20210103),
(3, 1808, 180600037, 20210104),
(4, 1809, 180600065, 20210105),
(5, 1810, 180600075, 20210106),
(6, 1811, 180600078, 20210107),
(7, 1812, 180600068, 20210108);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `c_c`
-- （参见下面的实际视图）
--
CREATE TABLE `c_c` (
`courseName` varchar(20)
,`courseCno` int(11)
,`type` varchar(20)
,`credit` tinyint(4)
,`curriculaVariable` varchar(20)
,`timePeriod` varchar(100)
,`teacherName` int(11)
,`tno` varchar(20)
,`capacity` int(11)
,`enrollment` int(11)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `c_n`
-- （参见下面的实际视图）
--
CREATE TABLE `c_n` (
`cno` int(11)
,`num` bigint(21)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `gpa`
-- （参见下面的实际视图）
--
CREATE TABLE `gpa` (
`sno` int(11)
,`avg_gpa` decimal(38,8)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `grade`
-- （参见下面的实际视图）
--
CREATE TABLE `grade` (
`sno` int(11)
,`cno` int(11)
,`curriculaVariable` varchar(20)
,`courseName` varchar(20)
,`courseType` varchar(20)
,`credit` tinyint(4)
,`grade` tinyint(5)
,`teacherName` varchar(20)
,`gpa` decimal(9,4)
);

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT '学生id',
  `sno` int(11) NOT NULL COMMENT '学号',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '学生姓名',
  `student_class` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '班级',
  `gpa` float NOT NULL COMMENT '绩点',
  `pwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `sno`, `name`, `student_class`, `gpa`, `pwd`) VALUES
(1, 1806100118, '小周小周', '计科186', 3.5, '2090578469'),
(2, 1806100119, '黎小浪', '计科186', 3.5, '12345677'),
(3, 1806100120, '王小天', '计科186', 2.5, '12345677'),
(4, 1806100121, '陈小波', '计科186', 3.5, '12345677');

-- --------------------------------------------------------

--
-- 表的结构 `student_class`
--

CREATE TABLE `student_class` (
  `id` int(11) NOT NULL COMMENT '选课id',
  `sno` int(11) NOT NULL COMMENT '学号',
  `grade` tinyint(5) NOT NULL COMMENT '成绩',
  `curricula_variable` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '教学班号'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `student_class`
--

INSERT INTO `student_class` (`id`, `sno`, `grade`, `curricula_variable`) VALUES
(1, 1806100118, 0, '131800701-1'),
(4, 1806100119, 87, '131800701-1'),
(5, 1806100120, 75, '131800701-2'),
(7, 1806100118, 78, '180600032-1'),
(8, 1806100118, 98, '180600078-1'),
(15, 1806100119, 80, '180600068-1');

--
-- 触发器 `student_class`
--
DELIMITER $$
CREATE TRIGGER `GPA_UPDATE` AFTER UPDATE ON `student_class` FOR EACH ROW UPDATE student
SET gpa=(SELECT SUM(course.credit * ifnull(grade.gpa,0))/sum(course.credit) as avg_gpa
FROM course,grade
WHERE course.cno = grade.cno AND grade.sno = OLD.sno
GROUP BY sno)
WHERE student.sno=OLD.sno
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- 替换视图以便查看 `student_schedule`
-- （参见下面的实际视图）
--
CREATE TABLE `student_schedule` (
`sno` int(11)
,`cno` int(11)
,`courseName` varchar(20)
,`timePeriod` varchar(100)
,`teacherName` varchar(20)
,`curriculaVariable` varchar(20)
,`classHours` tinyint(5)
,`credit` tinyint(4)
,`type` varchar(20)
);

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL COMMENT '教师id',
  `tno` int(11) NOT NULL COMMENT '教工号',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '教师名字',
  `pwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '教师密码',
  `identity` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '教师身份（系主任、课程负责人'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`id`, `tno`, `name`, `pwd`, `identity`) VALUES
(1, 20210102, '老古', '123456', 'teacher'),
(2, 20210103, '老刘', '123456', 'teacher'),
(3, 20210104, '老李', '123456', 'director'),
(4, 20210105, '老张', '123456', 'teacher'),
(5, 20210106, '老王', '123456', 'teacher'),
(6, 20210107, '老吴', '123456', 'teacher'),
(7, 20210108, '老周', '123456', 'teacher');

-- --------------------------------------------------------

--
-- 表的结构 `teacher_class`
--

CREATE TABLE `teacher_class` (
  `id` int(11) NOT NULL COMMENT '任课id',
  `tno` int(11) NOT NULL COMMENT '教工号',
  `time_period` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '任课时间段',
  `curricula_variable` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '教学班号'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teacher_class`
--

INSERT INTO `teacher_class` (`id`, `tno`, `time_period`, `curricula_variable`) VALUES
(38, 20210104, 'Fri|9-11', '180600037-1'),
(37, 20210105, 'Fri|5-6', '180600037-2'),
(36, 20210104, 'Fri|1-2', '180600032-2'),
(35, 20210102, 'Thu|9-11', '180600068-2'),
(34, 20210106, 'Thu|7-8', '180600075-1'),
(33, 20210103, 'Thu|5-6', '131800701-2'),
(32, 20210102, 'Thu|3-4', '131800701-1'),
(31, 20210107, 'Thu.Wed|3-4.1-2', '180600078-1'),
(30, 20210108, 'Wed|1-2', '180600068-1'),
(29, 20210107, 'Tue|7-8', '180600075-2'),
(28, 20210103, 'Tue|5-6', '180600032-1'),
(27, 20210106, 'Mon|7-8', '180600065-2'),
(26, 20210105, 'Mon|5-6', '180600065-1'),
(25, 20210108, 'Tue.Mon|1-2.3-4', '180600078-2');

-- --------------------------------------------------------

--
-- 表的结构 `teacher_group`
--

CREATE TABLE `teacher_group` (
  `id` int(11) NOT NULL COMMENT '教师课程组关系id',
  `gno` int(11) NOT NULL COMMENT '课程组号',
  `tno` int(11) NOT NULL COMMENT '教工号'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teacher_group`
--

INSERT INTO `teacher_group` (`id`, `gno`, `tno`) VALUES
(1, 1806, 20210102),
(2, 1806, 20210103),
(3, 1807, 20210103),
(4, 1807, 20210104),
(5, 1808, 20210104),
(6, 1808, 20210105),
(7, 1809, 20210105),
(8, 1809, 20210106),
(9, 1810, 20210106),
(10, 1810, 20210107),
(11, 1811, 20210107),
(12, 1811, 20210108),
(13, 1812, 20210108),
(14, 1812, 20210102);

-- --------------------------------------------------------

--
-- 表的结构 `teaching_class`
--

CREATE TABLE `teaching_class` (
  `id` int(11) NOT NULL COMMENT '课程安排id',
  `curricula_variable` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '教学班号'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teaching_class`
--

INSERT INTO `teaching_class` (`id`, `curricula_variable`) VALUES
(1, '131800701-1'),
(2, '131800701-2'),
(3, '180600032-1'),
(4, '180600037-1'),
(5, '180600065-1'),
(6, '180600075-1'),
(7, '180600078-1'),
(8, '180600068-1');

-- --------------------------------------------------------

--
-- 视图结构 `class_schedule`
--
DROP TABLE IF EXISTS `class_schedule`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `class_schedule`  AS  select `course_group`.`gno` AS `gno`,`teacher_group`.`tno` AS `tno`,`course_group`.`cno` AS `cno`,`course`.`type` AS `type`,`course`.`credit` AS `credit` from ((`course_group` join `teacher_group`) join `course`) where ((`course`.`cno` = `course_group`.`cno`) and (`course_group`.`gno` = `teacher_group`.`gno`)) ;

-- --------------------------------------------------------

--
-- 视图结构 `c_c`
--
DROP TABLE IF EXISTS `c_c`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `c_c`  AS  select `course`.`name` AS `courseName`,`course`.`cno` AS `courseCno`,`course`.`type` AS `type`,`course`.`credit` AS `credit`,`course_class`.`curricula_variable` AS `curriculaVariable`,`course_class`.`time_period` AS `timePeriod`,`teacher_class`.`tno` AS `teacherName`,`teacher`.`name` AS `tno`,`course_class`.`capacity` AS `capacity`,`course_class`.`enrollment` AS `enrollment` from (((`course` join `course_class`) join `teacher_class`) join `teacher`) where ((`course`.`cno` = `course_class`.`cno`) and (`course_class`.`curricula_variable` = `teacher_class`.`curricula_variable`) and (`teacher_class`.`tno` = `teacher`.`tno`) and (`course`.`type` = '专业选修')) ;

-- --------------------------------------------------------

--
-- 视图结构 `c_n`
--
DROP TABLE IF EXISTS `c_n`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `c_n`  AS  select `course_group`.`cno` AS `cno`,count(`teacher_group`.`tno`) AS `num` from (`course_group` join `teacher_group`) where (`course_group`.`gno` = `teacher_group`.`gno`) group by `course_group`.`cno` ;

-- --------------------------------------------------------

--
-- 视图结构 `gpa`
--
DROP TABLE IF EXISTS `gpa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gpa`  AS  select `grade`.`sno` AS `sno`,(sum((`course`.`credit` * ifnull(`grade`.`gpa`,0))) / sum(`course`.`credit`)) AS `avg_gpa` from (`course` join `grade`) where (`course`.`cno` = `grade`.`cno`) group by `grade`.`sno` ;

-- --------------------------------------------------------

--
-- 视图结构 `grade`
--
DROP TABLE IF EXISTS `grade`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `grade`  AS  select `student_class`.`sno` AS `sno`,`course`.`cno` AS `cno`,`student_class`.`curricula_variable` AS `curriculaVariable`,`course`.`name` AS `courseName`,`course`.`type` AS `courseType`,`course`.`credit` AS `credit`,`student_class`.`grade` AS `grade`,`teacher`.`name` AS `teacherName`,if((`student_class`.`grade` <= 50),0,if((`student_class`.`grade` >= 90),4,((`student_class`.`grade` - 50) / 10))) AS `gpa` from ((((`course` join `course_class`) join `student_class`) join `teacher_class`) join `teacher`) where ((`course`.`cno` = `course_class`.`cno`) and (`course_class`.`curricula_variable` = `student_class`.`curricula_variable`) and (`student_class`.`curricula_variable` = `teacher_class`.`curricula_variable`) and (`teacher_class`.`tno` = `teacher`.`tno`)) ;

-- --------------------------------------------------------

--
-- 视图结构 `student_schedule`
--
DROP TABLE IF EXISTS `student_schedule`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_schedule`  AS  select `student_class`.`sno` AS `sno`,`course_class`.`cno` AS `cno`,`course`.`name` AS `courseName`,`course_class`.`time_period` AS `timePeriod`,`teacher`.`name` AS `teacherName`,`course_class`.`curricula_variable` AS `curriculaVariable`,`course`.`class_hours` AS `classHours`,`course`.`credit` AS `credit`,`course`.`type` AS `type` from ((((`student_class` join `course_class`) join `course`) join `teacher_class`) join `teacher`) where ((`student_class`.`curricula_variable` = `teacher_class`.`curricula_variable`) and (`student_class`.`curricula_variable` = `course_class`.`curricula_variable`) and (`course`.`cno` = `course_class`.`cno`) and (`teacher`.`tno` = `teacher_class`.`tno`)) ;

--
-- 转储表的索引
--

--
-- 表的索引 `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `course_class`
--
ALTER TABLE `course_class`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `course_group`
--
ALTER TABLE `course_group`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `student_class`
--
ALTER TABLE `student_class`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `teacher_class`
--
ALTER TABLE `teacher_class`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `teacher_group`
--
ALTER TABLE `teacher_group`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `teaching_class`
--
ALTER TABLE `teaching_class`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id', AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `course_class`
--
ALTER TABLE `course_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程安排id', AUTO_INCREMENT=37;

--
-- 使用表AUTO_INCREMENT `course_group`
--
ALTER TABLE `course_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程组id', AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id', AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `student_class`
--
ALTER TABLE `student_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课id', AUTO_INCREMENT=16;

--
-- 使用表AUTO_INCREMENT `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id', AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `teacher_class`
--
ALTER TABLE `teacher_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任课id', AUTO_INCREMENT=39;

--
-- 使用表AUTO_INCREMENT `teacher_group`
--
ALTER TABLE `teacher_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师课程组关系id', AUTO_INCREMENT=15;

--
-- 使用表AUTO_INCREMENT `teaching_class`
--
ALTER TABLE `teaching_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程安排id', AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
