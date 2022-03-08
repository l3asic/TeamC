/** 
 * 
 */
// 
var join = {
	// tag의 상태를 확인할 수 있는 함수를 선언(tag_status)하고 받아오는 값은 tag 변수로 설정
	tag_status: function ( tag ) {
		var data = tag.val();	// tag 내 입력된 값을 data 변수에 할당 
		tag = tag.attr('name'); // tag 의 name 속성의 값을 확인 ex)id, pw, email ...
		
	// tag 에 입력한 값은 data에 들어있는데 tag 의 name 속성의 값으로 id, pw, pw_chk, email
	// 인지를 구분(판단)하여 유효성 검사 진행하고자 함.
		if ( tag == 'member_id')		return this.member_id_status ( data );
		else if (tag == 'member_pw')	return this.member_pw_status ( data );
		else if (tag == 'pw_ck')	return this.pw_ck_status ( data );
		else if (tag == 'member_email')	return this.member_email_status ( data );
		else if (tag == 'member_nick')	 return this.member_nick_status ( data );	 	 	
	}
	, member_id: { 
		  // id의 기준 설정
		invalid : { code : 'invalid' , desc :'아이디는 영문 소문자, 숫자만 입력 가능'}
		, valid : { code : 'valid' , desc : '아이디 중복 확인하세요'}
		  // 사용 가능한 상태.. 
		, usable : { code : 'valid', desc : '사용 가능한 아이디 입니다.'}
		, unUsable : { code : 'invalid', desc : '이미 사용 중인 아이디입니다.'}
		
	}
	, member_id_status : function ( member_id ) { // id 의 상태 확인
		var reg = /[^a-z0-9]/g;		// 소문자, 숫자 외 입력시
	
		/* 입력값이 없을 경우 */
		if(member_id == '')	return this.common.empty;
		/* 입력값에 공백이 있을 경우 */
		else if(member_id.match(space))	return this.common.space;
		/* 5자 이하 입력 여부 확인 */
		else if(member_id.length < 5 )		return this.common.min;
		/* 10자 이상 입력 여부 확인*/
		else if(member_id.length > 10 )	return this.common.max;
		/* 소문자, 숫자 외 문자 입력 여부 확인 */
		else if(reg.test(member_id))		return this.member_id.invalid;
		else						return this.member_id.valid;
	
	}
	
	
	, member_pw : {
		equal : { code : 'valid', desc : '비밀번호가 일치합니다.'}
		, notEqual : {code : 'invalid', desc : '비밀번호가 일치하지 않습니다.'}
		, valid : {code : 'valid', desc : '사용 가능한 비밀번호입니다.' }
		, invalid : {code : 'invalid', desc : '비밀번호를 영문 대/소문자, 숫자를 모두 포함'}
		, lack : {code : 'invalid', desc : '영문 대/소문자 숫자를 모두 포함해야 합니다.'}
	}
	, member_pw_status : function ( member_pw ) {
		var reg = /[^A-Za-z0-9]/g;
		var upper = /[A-Z]/g, lower = /[a-z]/g, digit = /[0-9]/g;
		if (member_pw == '')				return this.common.empty;
		else if(member_pw.match(space))	return this.common.space;
		else if(member_pw.length < 5)		return this.common.min;
		else if(member_pw.length > 10 )	return this.common.max;
		else if(reg.test(member_pw))		return this.member_id.invalid;
		/* ▼ 대문자, 소문자, 숫자가 하나라도 없다면 */
		else if(!upper.test(member_pw) || !lower.test(member_pw) || !digit.test(member_pw))		return this.member_pw.lack;
		else						return this.member_pw.valid;
	}
	, pw_ck_status : function ( pw_ck ) {
		if (pw_ck == '')			return this.common.empty;
		else if ( pw_ck == $('[name=member_pw]').val() )	return this.member_pw.equal;
		else 						return this.member_pw.notEqual;		
	}	
	
	
	, member_email_status : function ( member_email ) {
		var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if ( member_email == '')		return this.common.empty;	
		else if (member_email.match(space))	return this.common.space;
		else if (reg.test(member_email))		return this.member_email.valid;
		else 							return this.member_email.invalid;
	}
	, member_email : {
		valid : {code : 'valid', desc : '유효한 이메일입니다.'}
		, invalid : {code : 'invalid' , desc : '유효하지 않은 이메일 입니다.'}
	}
	
	
	, member_nick: { // nick의 기준 설정
		invalid : { code : 'invalid' , desc :'닉네임은 영문 소문자, 숫자만 입력 가능'}
		, valid : { code : 'valid' , desc : '닉네임 중복 확인하세요'}
		  // 사용 가능한 상태.. 
		, usable : { code : 'valid', desc : '사용 가능한 닉네임 입니다.'}
		, unUsable : { code : 'invalid', desc : '이미 사용 중인 닉네임입니다.'}
		
	}
	, member_nick_status : function ( member_nick ) { // nick 의 상태 확인
	
		var reg = /[^a-z0-9]/g;	
		//특수문자 입력시

		if (member_nick == '') return this.common.empty;
		else if (member_nick.match(space)) return this.common.space;
		else if (member_nick.length < 5) return this.common.min;
		else if (member_nick.length > 10) return this.common.max;
		// 소문자 숫자외 문자 입력 여부확인
		else if (reg.test(member_nick)) return this.member_nick.invalid;
		else                return this.member_nick.valid;
	}
	
	, common : { // 공통적으로 검사를 해야 할 항목을 지정
		empty : { code : 'invalid' , desc : '입력하세요' }
		, space : { code : 'invalid', desc : '공백없이 입력하세요'}
		, max : { code : 'invalid', desc : '최대 10자 이하로 입력하세요'}
		, min : { code : 'invalid', desc : '최소 5자 이상 입력하세요'}		
	}
	, member_id_usable : function ( usable ) {
		if (usable)	return this.member_id.usable;
		else 		return this.member_id.unUsable;
	}
	, member_nick_usable : function ( usable ) {
		if (usable)	return this.member_nick.usable;
		else 		return this.member_nick.unUsable;
	}
	
} 
var space = /\s/g;	// 전체 문자 내 공백이 있는지... space 해당










