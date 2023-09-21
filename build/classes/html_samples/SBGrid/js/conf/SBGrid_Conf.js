/**
 *		그리드 각종 설정 정보
 *		_SBGrid.CF.LOCALE : locale 설정 정보 (Object type)
 *
 *		locale 						: 그리드에 설정하려는 locale 코드 지정 (String Type)
 *		localeinfo 					: locale 코드별 설정 정보 지정 (Object type)
 *		localeinfo.코드 				: locale 코드 (Object Type)
 *		localeinfo.코드.datepicker	: 달력 locale 설정 (String Type)
 *			'ko' > 한국어
 *			'ar' > 아랍어
 *			'en' > 영어
 *			'de' > 독일어
 *			'es' > 스페인어
 *			'ja' > 일본어
 *			'zh-CN' > 중국어
 *		localeinfo.코드.caption		: 캡션 지정 (Array Type)
 *		localeinfo.코드.format		: format 지정 (Object Type)
 *		localeinfo.코드.format.rule	: format rule 지정 (String Type)
 *
 */

_SBGrid.CF.LOCALE = {
	'locale': 'K1',
	'localeinfo': {
		'K1': {
			'datepicker': 'ko',
			'caption': [['데이타'], ['날짜데이타'], ['날짜2데이타'], ['숫자데이타'], ['숫자2데이타'], ['달력데이타']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'C1': {
			'datepicker': 'zh-CN',
			'caption': [['数据'], ['日期-数据'], ['日期2-数据'], ['數字-数据'], ['數字2-数据'], ['月历-数据']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'A9': {
			'datepicker': 'en-AU',
			'caption': [['DATA'], ['DATE-DATA'], ['DATE1-DATA'], ['NUMBER-DATA'], ['NUMBER2-DATA'], ['CALENDAR-DATA']],
			'format': {
				'date': {
					'rule': 'dd-mm-yyyy'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'A7': {
			'datepicker': 'en-AU',
			'caption': [['DATA'], ['DATE-DATA'], ['DATE1-DATA'], ['NUMBER-DATA'], ['NUMBER2-DATA'], ['CALENDAR-DATA']],
			'format': {
				'date': {
					'rule': 'dd-mm-yyyy'
				},
				'number': {
					'rule': '#,###.00',
					'digitgroup': '.',
					'decimalgroup': ','
				}
			}
		},
		'KO': {
			'datepicker': 'ko',
			'caption': [['기본정보','학원명'], ['기본정보','설립자(성명)'], ['기본정보','전화번호'], ['기본정보','학원주소'], ['기본정보','교습과정'], ['상세정보','교습과목(반)'],['상세정보','정원'],['상세정보','교습기간'],['상세정보','교육시작일'],['상세정보','총교습시간(분)'],['상세정보','교습비'],['상세정보','강사수']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'JP': {
			'datepicker': 'ja',
			'caption': [['基本情報','学院名'], ['基本情報','成立者（生命）'], ['基本情報','電話番号'], ['基本情報','学院住所'], ['基本情報','教習課程'], ['詳細情報','教習科目(クラス)'],['詳細情報','定員'],['詳細情報','教習期間'],['詳細情報','教育開始日'],['詳細情報','総レッスン時間(分)'],['詳細情報','教習費'],['詳細情報','講師数']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			}
		}
	}
};
