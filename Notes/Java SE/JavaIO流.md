# Java I/O流

## 1. I/O流原理

I/O是Input/Output的缩写。I/O技术用于处理设备之间的数据传输。

如：

	- 读写文件
	- 网络通讯等

Java中，数据的输入输出以 **流（Stream）**的方式进行。 

`java.io`包下提供了各种**流**的类和接口，用以获取不同种类的数据，并通过标准的方法输入或输出。  

**输入（Input）**: 读取外部数据到程序（内存中）中。

**输出（Ouput）**：将程序（内存）中的数据写出到存储设备中。

## 2. 流的分类

按照流向：

 - 输入流(InputStream和Reader)：从输入源到内存
 - 输出流(OutputStream和Writer)：从内存到目标文件

按照数据单位：

- 字节流(8bit)：读写字节。
- 字符流(16bit)：读写字符。

 按照角色：

- 节点流：直接从数据源或目的地读写数据。
- 处理流：不直接连接到数据源或目的地，而是连接已经存在的流（节点流或处理流）

## 3. IO 流体系



| 分类       | 字节输入流           | 字节输出流           | 字符输入流        | 字符输出流         |
| ---------- | -------------------- | -------------------- | ----------------- | ------------------ |
| 抽象基类   | InputStream          | OutputStream         | Reader            | Writer             |
| 访问文件   | FileInputStream      | FileOutputStream     | FileReader        | FileWriter         |
| 访问数组   | ByteArrayInputStream | ByteArrayOutStream   | CharArrayReader   | CharArrayWriter    |
| 访问字符串 |                      |                      | StringReader      | StringWriter       |
| 缓冲流     | BufferedInputStream  | BufferedOutputStream | BufferedReader    | BufferedWriter     |
| 转换流     |                      |                      | InputStreamReader | OutputStreamWriter |
| 对象流     | OjbectInputStream    | ObjectOutputStream   |                   |                    |
| 过滤流     | FilterInputStream    | FilterOutputStream   | FilterReader      | FilterWriter       |
| 打印流     |                      | PrintStream          |                   | PrintWriter        |
| 推回输入流 |                      | PushBackInputStream  |                   | PrintWriter        |
| 特殊流     | DataInputStream      | DataOutputStream     |                   |                    |

