package com.kh.bookmanager.rent;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.bookmanager.book.Book;
import com.kh.bookmanager.member.Member;

import lombok.Data;

@Entity
@DynamicUpdate //변경이 감지된 속성만 쿼리에 반영
@DynamicInsert //값이 null이 아닌 속성만 쿼리에 반영 
@Data
public class RentBook {
	@Id
	@GeneratedValue
	private Long rbIdx;	
	
	@ManyToOne
	@JoinColumn(name = "bkIdx")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "rmIdx")
	private Rent rent;
	
	@Column(columnDefinition = "date default sysdate")
	private Date regDate;
	private String state;
	
	@Column(columnDefinition = "date default sysdate+7")
	private Date returnDate;
	
	@Column(columnDefinition = "number default 0")
	private Integer extensionCnt;

}