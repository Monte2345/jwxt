-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2021-01-07 17:41:38
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
  `time_period` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程安排时间段'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `course_class`
--

INSERT INTO `course_class` (`id`, `cno`, `curricula_variable`, `time_period`) VALUES
(1, 131800701, '131800701-1', 'Tue.Wed|7-8.1-2'),
(2, 131800701, '131800701-2', 'Tue.Wed|1-2.3-4'),
(3, 180600032, '180600032-1', 'Mon.Wed|7-8.5-6'),
(4, 180600037, '180600037-1', 'Fri|3-4'),
(5, 180600065, '180600065-1', 'Thu|5-6'),
(6, 180600075, '180600075-1', 'Tue|3-4'),
(7, 180600078, '180600078-1', 'Mon.Fri|7-8.3-4'),
(8, 180600068, '180600068-1', 'Wed|9-11');

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
(3, 1806100120, '王小天', '计科186', 3.5, '12345677'),
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
(4, 1806100119, 0, '131800701-1'),
(5, 1806100120, 0, '131800701-2'),
(7, 1806100118, 0, '180600032-1'),
(8, 1806100118, 0, '180600078-1');

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
(1, 20210102, '1-16|Tue.Wed|7-8.1-2', '131800701-1'),
(2, 20210103, '1-16|Tue.Wed|1-2.3-4', '131800701-2'),
(3, 20210104, '1-16|Mon.Wed|7-8.5-6', '180600032-1'),
(4, 20210105, '1-16|Fri|3-4', '180600037-1'),
(5, 20210106, '1-16|Thu|5-6', '180600065-1'),
(6, 20210107, '1-16|Tue|3-4', '180600075-1'),
(7, 20210108, '1-16|Mon.Fri|7-8.3-4', '180600078-1'),
(8, 20210108, '1-16|Wed|9-11', '180600068-1');

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
-- 视图结构 `c_c`
--
DROP TABLE IF EXISTS `c_c`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `c_c`  AS  select `course`.`name` AS `courseName`,`course`.`cno` AS `courseCno`,`course`.`type` AS `type`,`course`.`credit` AS `credit`,`course_class`.`curricula_variable` AS `curriculaVariable`,`course_class`.`time_period` AS `timePeriod`,`teacher_class`.`tno` AS `teacherName`,`teacher`.`name` AS `tno` from (((`course` join `course_class`) join `teacher_class`) join `teacher`) where ((`course`.`cno` = `course_class`.`cno`) and (`course_class`.`curricula_variable` = `teacher_class`.`curricula_variable`) and (`teacher_class`.`tno` = `teacher`.`tno`) and (`course`.`type` = '专业选修')) ;

-- --------------------------------------------------------

--
-- 视图结构 `student_schedule`
--
DROP TABLE IF EXISTS `student_schedule`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_schedule`  AS  select `student`.`sno` AS `sno`,`course`.`cno` AS `cno`,`course`.`name` AS `courseName`,`course_class`.`time_period` AS `timePeriod`,`teacher`.`name` AS `teacherName`,`course_class`.`curricula_variable` AS `curriculaVariable`,`course`.`class_hours` AS `classHours`,`course`.`credit` AS `credit` from (((((`student_class` join `course_class`) join `student`) join `teacher_class`) join `teacher`) join `course`) where ((`course`.`cno` = `course_class`.`cno`) and (`course_class`.`curricula_variable` = `teacher_class`.`curricula_variable`) and (`teacher_class`.`tno` = `teacher`.`tno`) and (`student_class`.`sno` = `student`.`sno`) and (`student_class`.`curricula_variable` = `course_class`.`curricula_variable`)) ;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程安排id', AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id', AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `student_class`
--
ALTER TABLE `student_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课id', AUTO_INCREMENT=12;

--
-- 使用表AUTO_INCREMENT `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id', AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `teacher_class`
--
ALTER TABLE `teacher_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任课id', AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `teaching_class`
--
ALTER TABLE `teaching_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程安排id', AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
