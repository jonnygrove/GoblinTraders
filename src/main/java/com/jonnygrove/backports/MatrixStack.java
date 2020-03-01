package com.jonnygrove.backports;

import com.google.common.collect.Queues;
import java.util.Deque;
// import net.minecraft.client.renderer.Quaternion;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MatrixStack {
   private final Deque<MatrixStack.Entry> stack = Util.make(Queues.newArrayDeque(), (p_227864_0_) -> {
      Matrix4f matrix4f = new Matrix4f();
      matrix4f.identity();
      Matrix3f matrix3f = new Matrix3f();
      matrix3f.identity();
      p_227864_0_.add(new MatrixStack.Entry(matrix4f, matrix3f));
   });

   public void translate(double p_227861_1_, double p_227861_3_, double p_227861_5_) {
      MatrixStack.Entry matrixstack$entry = this.stack.getLast();
      matrixstack$entry.positionMatrix.multiply(Matrix4f.func_226599_b_((float)p_227861_1_, (float)p_227861_3_, (float)p_227861_5_));
   }

   public void scale(float p_227862_1_, float p_227862_2_, float p_227862_3_) {
      MatrixStack.Entry matrixstack$entry = this.stack.getLast();
      matrixstack$entry.positionMatrix.multiply(Matrix4f.func_226593_a_(p_227862_1_, p_227862_2_, p_227862_3_));
      if (p_227862_1_ == p_227862_2_ && p_227862_2_ == p_227862_3_) {
         if (p_227862_1_ > 0.0F) {
            return;
         }

         matrixstack$entry.normalMatrix.func_226111_a_(-1.0F);
      }

      float f = 1.0F / p_227862_1_;
      float f1 = 1.0F / p_227862_2_;
      float f2 = 1.0F / p_227862_3_;
      float f3 = func_226166_j_(f * f1 * f2);
      matrixstack$entry.normalMatrix.func_226118_b_(Matrix3f.func_226117_b_(f3 * f, f3 * f1, f3 * f2));
   }
   
   public static float func_226166_j_(float p_226166_0_) {
	      int i = Float.floatToIntBits(p_226166_0_);
	      i = 1419967116 - i / 3;
	      float f = Float.intBitsToFloat(i);
	      f = 0.6666667F * f + 1.0F / (3.0F * f * f * p_226166_0_);
	      f = 0.6666667F * f + 1.0F / (3.0F * f * f * p_226166_0_);
	      return f;
	   }

   public void rotate(Quaternion p_227863_1_) {
      MatrixStack.Entry matrixstack$entry = this.stack.getLast();
      matrixstack$entry.positionMatrix.multiply(p_227863_1_);
      matrixstack$entry.normalMatrix.func_226115_a_(p_227863_1_);
   }

   public void push() {
      MatrixStack.Entry matrixstack$entry = this.stack.getLast();
      this.stack.addLast(new MatrixStack.Entry(matrixstack$entry.positionMatrix.copy(), matrixstack$entry.normalMatrix.func_226121_d_()));
   }

   public void pop() {
      this.stack.removeLast();
   }

   public MatrixStack.Entry getLast() {
      return this.stack.getLast();
   }

   public boolean func_227867_d_() {
      return this.stack.size() == 1;
   }

   @OnlyIn(Dist.CLIENT)
   public static final class Entry {
      private final Matrix4f positionMatrix;
      private final Matrix3f normalMatrix;

      private Entry(Matrix4f p_i225909_1_, Matrix3f p_i225909_2_) {
         this.positionMatrix = p_i225909_1_;
         this.normalMatrix = p_i225909_2_;
      }

      public Matrix4f getPositionMatrix() {
         return this.positionMatrix;
      }

      public Matrix3f getNormalMatrix() {
         return this.normalMatrix;
      }
   }
}