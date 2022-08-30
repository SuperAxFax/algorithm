- 为了频繁操作字符串，推出了StringBuilder，简称为sb。因为为了解决线程安全问题推出了小sb也就是StringBuffer。由于内部使用了synchronized关键字进行加锁使得StringBuffer的效率就没那么高了。StringBuffer比StringBuilder出来的要早。

## 2: StringBuilder源码

```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {}
```

```java
public final class StringBuilder
    extends AbstractStringBuilder
    implements java.io.Serializable, CharSequence
{
//无参构造
public StringBuilder() {
        super(16);
    }
//根据容量的有参构造
public StringBuilder(int capacity) {
        super(capacity);
    }
//根据字符串的有参构造
public StringBuilder(String str) {
        super(str.length() + 16);
        append(str);
    }
//如果是字符串拼接的话就调用append方法
@Override//紧接着它去调用父类AbstractStringBuilder的append方法
    public StringBuilder append(String str) {
        super.append(str);
        return this;//return this表示谁调用它，它就返回谁
    }
  
  @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }
}





abstract class AbstractStringBuilder implements Appendable, CharSequence 
{
//StrignBuilder的父类首先会创建一个字符串数组用来存储数据
  char[] value;
//接着调用父类的append方法，
  //1：首先判断传来的字符串是否为空，如果为空就将null以字符的形式添加到value数组中
  //2：接着将字符串的长度与之前value数组中的长度相加来判断是否需要对数组扩容
  //3：将目标字符串内容复制到value数组中
  //4：更新当前字符长度并返回
public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;//接着返回到StringBuffer中的public StringBuilder append(String str){}
    }
  
  
  
  
  
  
  
  
  
  //上述代码的分支
private AbstractStringBuilder appendNull() {
        int c = count;
        ensureCapacityInternal(c + 4);
        final char[] value = this.value;
        value[c++] = 'n';
        value[c++] = 'u';
        value[c++] = 'l';
        value[c++] = 'l';
        count = c;
        return this;
    }
//判断是否需要对value数组扩容，如果之前数组中的元素与要添加的元素之和比设定的16还要大则进行扩容
private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0)
            expandCapacity(minimumCapacity);
    }
//扩容代码，首先将数组长度乘2再加2。如果该方式下还不满足则将所需长度直接赋值给newCapacity。如果所需长度小于0则报地址越界异常。接着更新数组长度。
void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0)
            newCapacity = minimumCapacity;
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }

public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
        if (srcBegin < 0) {
            throw new StringIndexOutOfBoundsException(srcBegin);
        }
        if (srcEnd > value.length) {
            throw new StringIndexOutOfBoundsException(srcEnd);
        }
        if (srcBegin > srcEnd) {
            throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);
        }
    //value:数据源 
    //srcBegin：起始的位置 
    //dst：目标数组 
    //dstBegin：目标数组起始位置 
    //srcEnd - srcBegin：要拷贝元素的个数
        System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
    }
}
```

以存储字符串为例，首先StringBuilder会使用有参构造向父类AbstractStringBuilder传递容器的长度为字符串的长度加16，接着调用append方法。StringBuilder的append方法去调用父类AbstractStringBuilder的append方法。父类会创建一个字符串数组。父类的append方法首先判断字符串是否为空，如果字符串为空则将null添加到字符串数组中，如果不为空就根据字符串的长度与之前元素长度与所要添加的元素之和进行比较来判断是否需要扩容。如果空间不够则进行扩容操作，扩容操作具体是先将数组长度乘2再加2，如果还不够就直接将所需的数组长度直接赋值给新的数组长度。扩容完成后就执行赋值操作，将所要存储的字符串赋值到AbstractStringBuilder创建的字符串数组中。接着更新当前字符串数组长度并返回给StringBuilder的append方法。

