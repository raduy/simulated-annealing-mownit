package com.raduy.presentation;

import com.raduy.core.AnnealingResult;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public interface IPresentationStrategy {

    void present(AnnealingResult annealingResult);
}
