package com.cocoa.util.box;

public class BoxDemo {

    /**
     * 1.基本类型与包装类型 "==" 比较时,包装类型自动拆箱,两个基本类型比较
     * 2.包装类型与包装类型 "==" 地址引用的比较 注:自动装箱的情况
     *
     */
    public static void f1(){

        int n1 = 50;
        Integer n2 = 50;
        Integer n3 = new Integer(50);
        Integer n4 = Integer.valueOf(1);
        Integer n5 = Integer.parseInt("1");
        Integer n6 = new Integer(50);
        Integer n7 = 500;
        Integer n8 = new Integer((50));
        Integer n9 = Integer.valueOf(50);
        System.out.println("n1==n2: "+(n1==n2));
        System.out.println("n1==n3: "+(n1==n3));
        System.out.println("n2==n3: "+(n2==n3));
        System.out.println("n3==n6: "+(n3==n6));
        System.out.println("n3==n6: "+(n3==n6));
        System.out.println("n3==n4: "+(n3==n4));
        System.out.println("n3==n5: "+(n3==n5));
        System.out.println("n2==n7: "+(n2==n7));
        System.out.println("n3==n8: "+(n3==n8));
        System.out.println("n3==n9: "+(n3==n9));
        System.out.println("n2==n9: "+(n2==n9));
        System.out.println("-------------");
        System.out.println("n2 eq n1: "+(n2.equals(n1)));

    }

    /**
     * 包装类缓存了-127 ～ 128 的包装类缓存对象,在"=="的比较时,对象是同一个所以"相等"
     * 自动装箱使用的是XXX.valueOf()方法,若初始化在[-127,128]范围内,会创建的缓存包装类并返回,否则new新的包装类
     * Float,Double浮点数包装类 valueOf()没有使用缓存类
     */
    public static void cache(){

        Integer n1 = 10;
        Integer n2 = Integer.valueOf(10);
        Integer n3 = Integer.valueOf("10");
        System.out.println("n1==n2: "+(n1==n2));
        System.out.println("n2==n3: "+(n2==n3));

        System.out.println("--------------");
        Integer a1 = 500;
        Integer a2 = Integer.valueOf(500);
        System.out.println("a1==a2: "+(a1==a2));

        System.out.println("--------------");
        Long b1 = 20L;
        Long b2 = Long.valueOf(20L);
        Long b10 = 300L;
        Long b20 = Long.valueOf(300L);
        System.out.println("b1==b2: "+(b1==b2));
        System.out.println("b10==b20: "+(b10==b20));

        System.out.println("---------------");
        Float c1 = 1F;
        Float c2 = Float.valueOf(1F);
        System.out.println("c1==c2: "+(c1==c2));

        System.out.println("---------------");
        Double d1 = 1D;
        Double d2 = Double.valueOf(1D);
        System.out.println("d1==d2: "+(d1==d2));

    }

    /**
     * 基本类型与包装类型"==" 包装类型自动拆箱转成基本类型,再值比较
     * 包装类型与包装类型"eq" 比较类型再比较值
     * 包装类型与基本类型"eq" 基本类型自动装箱,再eq
     */
    public static void eq(){
        int a1 = 10;
        Integer a2 = 10; //自动装箱 valueOf() 缓存类
        int b1 = 300;
        Integer b2 = 300;
        System.out.println("a1==a2: "+(a1==a2));
        System.out.println("b1==b2: "+(b1==b2));
        System.out.println("---------------------");

        long c1 = 10L;
        Integer a20 = new Integer(10);
        System.out.println("a2==a20: "+(a2==a20));
        System.out.println("a2.eq(a20): "+a2.equals(a20));
        System.out.println("a2.eq(c1): "+a2.equals(c1));

    }



    public static void main(String[] args) {
        //f1();
        //cache();
        eq();
    }

}
