package com.yuruiyin.richeditor.model

import com.yuruiyin.richeditor.enumtype.BlockImageSpanType
import com.yuruiyin.richeditor.model.IBlockImageSpanObtainObject

/**
 * Title:
 * Description:
 *
 * @author yuruiyin
 * @version 2019-05-10
 */
data class VideoVm(val path: String, val id: String): IBlockImageSpanObtainObject {
    override fun getType(): String = BlockImageSpanType.VIDEO
}