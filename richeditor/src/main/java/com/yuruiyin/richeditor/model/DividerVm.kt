package com.yuruiyin.richeditor.model

import com.yuruiyin.richeditor.enumtype.BlockImageSpanType

/**
 * Title: 分割线实体
 * Description:
 *
 * @author yuruiyin
 * @version 2019-05-14
 */
public class DividerVm: IBlockImageSpanObtainObject {
    override fun getType(): String = BlockImageSpanType.DIVIDER
}