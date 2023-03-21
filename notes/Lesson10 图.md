# 图

2023/03/21

### 图的基本概念

在**线性表**中，数据元素之间是被串起来的，仅有线性关系，每个数据元素只有一个直接前驱和一个直接后继。

![img](Lesson10%20%E5%9B%BE.assets/v2-a169e0edee40127180e360c7f1b8eb34_720w.webp)

在**树形结构**中，数据元素之间有着明显的层次关系，并且每一层上的数据元素可能和下一层中多个元素相关，但只能和上一层中一个元素相关。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210222181920216.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1JlYWxfRm9vbF8=,size_16,color_FFFFFF,t_70#pic_center)



在**图形结构**中，结点之间的关系可以是任意的，图中任意两个数据元素之间都可能相关。

![image-20230321214701475](Lesson10%20%E5%9B%BE.assets/image-20230321214701475.png)

 

##### 顶点

图中带编号的点就是顶点



##### 边

连接两个顶点的连线称作边



##### 有向图

![在这里插入图片描述](Lesson10%20%E5%9B%BE.assets/20210227111745661.png)

##### 无向图

![在这里插入图片描述](Lesson10%20%E5%9B%BE.assets/20210227112230368.png)



##### 带权图

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210301110502994.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1JlYWxfRm9vbF8=,size_16,color_FFFFFF,t_70#pic_center)



##### 路径

在图上任取两顶点，分别作为起点和终点，连接起点和终点且不会重复经过同一个点和同一条边的路线，就是一条“路径”。



##### 路径长度

无权图：顶点序列上经过的边的个数

有权图：顶点序列上经过的边的权重之和



##### 距离

从顶点u出发到顶点v的最短路径若存在，则此路径的长度称为从u到v的距离。若从u到v根本不存在路径，则记该距离为无穷( ∞ )。



### 