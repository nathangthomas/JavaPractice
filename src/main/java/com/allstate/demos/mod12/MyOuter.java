
package com.allstate.demos.mod12;

import com.allstate.repository.EmployeeImplMongo;

public class MyOuter {

    public int getAnOuterField() {
        return anOuterField;
    }

    public void setAnOuterField(int anOuterField) {
        this.anOuterField = anOuterField;
    }

    private int anOuterField;

    public class MyInner {
        public int getAnInnerField() {
            return anInnerField;
        }

        public void setAnInnerField(int anInnerField) {
            this.anInnerField = anInnerField;
        }

        private int anInnerField;

        public  void doWork() {
            this.anInnerField++;
            MyOuter.this.anOuterField --;
        }

    }

    public void doComplexWork() {
        class CoOrdX
        {
            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getZ() {
                return z;
            }

            public void setZ(int z) {
                this.z = z;
            }

            public int getI() {
                return i;
            }

            public void setI(int i) {
                this.i = i;
            }
            int x, y, z, i;
        }

        CoOrdX coOrd= new CoOrdX();
        coOrd.setI(12);
        coOrd=null;
    }

    public void doExtraComplexWork() {
        int x=10;
        EmployeeImplMongo employeeImplMongo = new EmployeeImplMongo(){
            @Override
            public void cleardb() {
                System.out.println("clear db");
            }
        };

        employeeImplMongo.cleardb();
    }

    public MyNestedClass createInner() {
        return new MyNestedClass();
    }

    public static class MyNestedClass{
        public int abs() {
            return 10;
        }
        public  static  int round() {
            return 100;
        }
    }
}
