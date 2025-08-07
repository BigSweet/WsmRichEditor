package com.yuruiyin.richeditor.model

import com.yuruiyin.richeditor.enumtype.BlockImageSpanType
import com.yuruiyin.richeditor.model.IBlockImageSpanObtainObject

/**
 * Title:
 * Description:
 *
 * @author yuruiyin
 * @version 2019-05-16
 */
data class GameVm(val id: Long, val name: String,val image:String,val desc:String): IBlockImageSpanObtainObject {
    override fun getType(): String  = BlockImageSpanType.GAME
}