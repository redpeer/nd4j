/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.indexaccum;

import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseIndexAccumulation;
import org.nd4j.linalg.factory.Nd4j;

import java.util.List;

/**
 * Calculate the index
 * of max value over a vector
 * @author Alex Black
 */
public class IMax extends BaseIndexAccumulation {
    public IMax(SameDiff sameDiff, DifferentialFunction i_v, int[] dimensions) {
        super(sameDiff, i_v, dimensions);
    }

    public IMax(SameDiff sameDiff, DifferentialFunction i_v, DifferentialFunction i_v2, int[] dimensions) {
        super(sameDiff, i_v, i_v2, dimensions);
    }

    public IMax() {}

    public IMax(INDArray x, INDArray y, long n) {
        super(x, y, n);
    }

    public IMax(INDArray x) {
        super(x);
    }

    public IMax(INDArray x, INDArray y) {
        super(x, y);
    }


    @Override
    public int opNum() {
        return 0;
    }

    @Override
    public String opName() {
        return "imax";
    }


    @Override
    public float zeroFloat() {
        return 0.0f;
    }

    @Override
    public double zeroDouble() {
        return 0.0;
    }

    @Override
    public float zeroHalf() {
        return zeroFloat();
    }

    @Override
    public IComplexNumber zeroComplex() {
        return Nd4j.createComplexNumber(-Double.MAX_VALUE, 0);
    }

    @Override
    public String onnxName() {
        return "ArgMax";
    }

    @Override
    public String tensorflowName() {
        return "argmax";
    }

    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> f1) {
        return null;
    }
}
