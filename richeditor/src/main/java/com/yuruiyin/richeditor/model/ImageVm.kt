package com.yuruiyin.richeditor.model

import com.yuruiyin.richeditor.enumtype.BlockImageSpanType
import com.yuruiyin.richeditor.model.IBlockImageSpanObtainObject

/**
 * Title: 图片实体
 * Description:
 *
 * @author yuruiyin
 * @version 2019-05-06
 */
data class ImageVm(val path: String, val id: String): IBlockImageSpanObtainObject {
    override fun getType(): String = BlockImageSpanType.IMAGE
}