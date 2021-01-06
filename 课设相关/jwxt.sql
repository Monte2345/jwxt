-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2021-01-05 20:46:14
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
  `status` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程状态'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT '学生id',
  `sno` int(11) NOT NULL COMMENT '学号',
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '学生姓名',
  `student_class` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '班级',
  `gpa` float NOT NULL COMMENT '绩点',
  `pwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `sno`, `name`, `student_class`, `gpa`, `pwd`) VALUES
(1, 1806100118, '小周小周', '计科186', 3.5, '2090578469');

-- --------------------------------------------------------

--
-- 表的结构 `student_course`
--

CREATE TABLE `student_course` (
  `id` int(11) NOT NULL COMMENT '选课id',
  `cno` int(11) NOT NULL COMMENT '课程号',
  `sno` int(11) NOT NULL COMMENT '学号',
  `tno` int(11) NOT NULL COMMENT '教工号',
  `time_period` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '选课时间段',
  `grade` tinyint(5) NOT NULL COMMENT '成绩'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL COMMENT '教师id',
  `tno` int(11) NOT NULL COMMENT '教工号',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '教师名字',
  `pwd` int(50) NOT NULL COMMENT '教师密码',
  `identity` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '教师身份（系主任、课程负责人'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`id`, `tno`, `name`, `pwd`, `identity`) VALUES
(1, 1806, '老古', 123456, '');

-- --------------------------------------------------------

--
-- 表的结构 `teacher_course`
--

CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL COMMENT '任课id',
  `cno` int(11) NOT NULL COMMENT '课程号',
  `tno` int(11) NOT NULL COMMENT '教工号',
  `time_period` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '任课时间段'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转储表的索引
--

--
-- 表的索引 `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `student_course`
--
ALTER TABLE `student_course`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `teacher_course`
--
ALTER TABLE `teacher_course`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id';

--
-- 使用表AUTO_INCREMENT `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id', AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `student_course`
--
ALTER TABLE `student_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课id';

--
-- 使用表AUTO_INCREMENT `teacher_course`
--
ALTER TABLE `teacher_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任课id';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
