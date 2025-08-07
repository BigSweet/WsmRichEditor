package com.yuruiyin.richeditor.span;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import com.yuruiyin.richeditor.enumtype.RichTypeEnum;
import com.yuruiyin.richeditor.model.AtVm;

/**
 * Title:
 * Description:
 *
 * @author yuruiyin
 * @version 2019-04-29
 */
public class AtStyleSpan extends ForegroundColorSpan implements IInlineSpan {

    private String type;
    AtVm atVm;

    public AtVm getAtVm() {
        return atVm;
    }

    public void setAtVm(AtVm atVm) {
        this.atVm = atVm;
    }

    public AtStyleSpan() {
        super(Color.RED);
        type = RichTypeEnum.AT;
    }

    public AtStyleSpan(AtVm atVm) {
        super(Color.RED);
        this.atVm = atVm;
        type = RichTypeEnum.AT;
    }

    @Override
    public String getType() {
        return type;
    }

}
