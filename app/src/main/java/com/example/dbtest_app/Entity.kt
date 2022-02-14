package com.example.dbtest_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity (
    var title : String
){
    @PrimaryKey(autoGenerate = true)// PrimaryKey 를 자동적으로 생성
    var id: Int = 0
}
