package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.*
import com.it_zoo.kostya05983.auto_aliance.Franchising.DataFranchisinGrid
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_franchising.*
import org.w3c.dom.Text

class FranchisingActivity : AbstractNavigation() {
    private val collectionAgry: MutableList<DataFranchisinGrid> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_franchising)


        fillCollection()
        acrivity_franchising.adapter = FranshingAdapterListActivity(this)

        nav_view_franchising.setNavigationItemSelectedListener(this)
    }

    private fun fillCollection() {
        this.collectionAgry.add(
                DataFranchisinGrid(
                        "\"Авто 99\"",
                        "Стоимость 99 000 рублей",
                        mutableListOf(
                                "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                                "Размещение на основном сайте и корпоративный чат 24\\7",
                                "Использование диспетчерской службы 8 - 800",
                                "GPS - трекинг транспорта",
                                "CRM - система индивидуально на город",
                                "Рекламные акции и материалы для продвижения"
                        ),
                        "При выборе данной программы: ",
                        mutableListOf(
                                "Предоставляем доступ к сайту, почте и корп. чату;",
                                "Доступ к CRM-системе Вашего города;",
                                "Диспетчерская и ежедневные заказы;",
                                "Рекламные материалы;",
                                "Обучение и помощь на всех этапах ведения проекта"
                        ),
                        "Паушальная сумма: 99 000 рублей.",
                        null,
                        "Фиксированное роялти: 1 500 рублей/автомобиль.",
                        "(Исключительно после обучения и запуска бизнеса)"
                )
        )


        this.collectionAgry.add(
                DataFranchisinGrid(
                        "\"Авто 149\"",
                        "Стоимость 149 000 рублей",
                        mutableListOf(
                                "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                                "Размещение на основном сайте и корпоративный чат 24\\7",
                                "Использование диспетчерской службы 8 - 800",
                                "GPS - трекинг транспорта",
                                "Доступ к CRM вашего города",
                                "Рекламные акции и материалы для продвижения",
                                "Офис в фирменном стиле",
                                "Программа \"Авто+1\"",
                                "1 автомобиль сразу"
                        ),
                        "При выборе данной программы: ",
                        mutableListOf(
                                "Регистрируем ваше предприятие;",
                                "Подготавливаем офис к открытию;",
                                "Занимаетесь сбором необходимой информации;",
                                "Знакомство с лизингом и программой \"Авто+1\";",
                                "Обучение и помощь на всех этапах ведения проекта"
                        ),
                        "Паушальная сумма: 149 000 рублей.",
                        null,
                        "Фиксированный роялти: 1 500 рублей/автомобиль.",
                        null
                        )
        )
        this.collectionAgry.add(
                DataFranchisinGrid(
                        "\"Авто 249\"",
                        "Стоимость 249 000 рублей",
                        mutableListOf(
                                "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                                "Размещение на основном сайте и корпоративный чат 24\\7",
                                "Использование диспетчерской службы 8 - 800",
                                "GPS - трекинг транспорта",
                                "Доступ к CRM вашего города",
                                "Рекламные акции и материалы для продвижения",
                                "Офис в фирменном стиле",
                                "Программа \"Авто+1\"",
                                "1 автомобиль сразу"
                        ),
                        null,
                        null,
                        "Паушальная сумма: 249 000 рублей.",
                        null,
                        "Фиксированный роялти: 1 500 рублей/автомобиль.",
                        "Ваша прибыль составит: не менее 150 000 рублей чистого дохода в месяц (к расчёту взято направление проката авто без дополнительных программ)"
                )
        )

        this.collectionAgry.add(
                DataFranchisinGrid(
                        "\"Инвестор\"",
                        null,
                        null,
                        null,
                        null,
                        null,
                        mutableListOf(
                                "Индивидуальные условия инвестирования в прибыльное направление автопроката с фиксированной процентной ставкой.",
                                "Обеспечение инвестирования имуществом на весь срок договора.",
                                "Сумма инвестирования от 2илн. рублей.",
                                "Срок договора 12 месяцев с последующей пролонгацией."
                        ),
                        null,
                        null
                )
        )

    }

    inner class FranshingAdapterListActivity(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var gridMain: View

                gridMain = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                when(position){
                    0,1 -> {
                        gridMain = inflater.inflate(R.layout.franshing_cell_grid,parent,false)
                    }
                    2->{
                        gridMain = inflater.inflate(R.layout.franshing_cell_grid_2,parent,false)
                    }
                    3 ->{
                        gridMain = inflater.inflate(R.layout.franshing_cell_grid_3,parent,false)
                    }
                }



            when(position){
                0,1->{
                    val linerLayout = gridMain as LinearLayout

                    val title_1 = linerLayout.getChildAt(0) as TextView
                    val subtitle_1 = linerLayout.getChildAt(1) as TextView
                    val listSectionFirst = linerLayout.getChildAt(2) as ListView
                    val titleBetwenSection = linerLayout.getChildAt(3) as TextView
                    val listSectionSecond = linerLayout.getChildAt(4) as ListView
                    val price_1 = linerLayout.getChildAt(5) as TextView
                    val fixprice = linerLayout.getChildAt(6) as TextView
                    val additionalInfo = linerLayout.getChildAt(7) as TextView

                    title_1.text = collectionAgry[position].Title
                    subtitle_1.text = collectionAgry[position].SubTitle
                    listSectionFirst.adapter = FranshingAdapterListSection1(position, linerLayout.context)
                    titleBetwenSection.text = collectionAgry[position].additionBetwenSections;
                    listSectionSecond.adapter = FranshingAdapterListSection2(position, linerLayout.context)
                    price_1.text = collectionAgry[position].PaushPrice
                    fixprice.text = collectionAgry[position].FixPrice

                    //additionalInfo.text = if(collectionAgry[position].additionInfo!= null) collectionAgry[position].additionInfo else ""
                }
                2->{
                    val linerLayout = gridMain as LinearLayout

                    val title_1 = linerLayout.getChildAt(0) as TextView
                    val subtitle_1 = linerLayout.getChildAt(1) as TextView
                    val listSection = linerLayout.getChildAt(2) as ListView
                    val price_1 = linerLayout.getChildAt(3) as TextView
                    val fixprice = linerLayout.getChildAt(4) as TextView
                    val additionalInfo = linerLayout.getChildAt(5) as TextView

                    title_1.text = collectionAgry[position].Title
                    subtitle_1.text = collectionAgry[position].SubTitle
                    listSection.adapter = FranshingAdapterListSection1(position, linerLayout.context)
                    price_1.text = collectionAgry[position].PaushPrice
                    fixprice.text = collectionAgry[position].FixPrice
                    additionalInfo.text = collectionAgry[position].additionInfo
                }
                3->{
                    val linerLayout = gridMain as LinearLayout

                    val title = linerLayout.getChildAt(0) as TextView
                    val listInvestor = linerLayout.getChildAt(1) as ListView

                    title.text = collectionAgry[position].Title
                    listInvestor.adapter = FranshingAdapterInvestor(position, linerLayout.context)
                }
            }

            return gridMain
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = collectionAgry.size
    }

    inner class FranshingAdapterListSection1(private val index: Int, private val mContext: Context) : BaseAdapter() {
        private val indexOfBlock: Int = index
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var gridMain: View
            if( convertView == null) {
                gridMain = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                gridMain = inflater.inflate(R.layout.fashing_cell_item_list,parent,false)
            } else {
                gridMain = convertView
            }
            val checkBox = gridMain.findViewById<CheckBox>(R.id.checkBox)
            checkBox.isChecked = true;

            val item = gridMain.findViewById<TextView>(R.id.item_section_ui)
            item.text = collectionAgry[indexOfBlock].sectionFirst!![position]

            return gridMain
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = collectionAgry[indexOfBlock].sectionFirst!!.size
    }

    inner class FranshingAdapterListSection2(private val index: Int, private val mContext: Context) : BaseAdapter() {
        private val indexOfBlock: Int = index
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var gridMain: View
            if( convertView == null) {
                gridMain = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                gridMain = inflater.inflate(R.layout.fashing_cell_item_list,parent,false)
            } else {
                gridMain = convertView
            }

            val checkBox = gridMain.findViewById<CheckBox>(R.id.checkBox)
            checkBox.isChecked = true;

            val item = gridMain.findViewById<TextView>(R.id.item_section_ui)
            item.text = collectionAgry[indexOfBlock].sectionSecond!![position]

            return gridMain
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = collectionAgry[indexOfBlock].sectionSecond!!.size
    }

    inner class FranshingAdapterInvestor(private val index: Int, private val mContext: Context) : BaseAdapter() {
        private val indexOfBlock: Int = index
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var gridMain: View
            if( convertView == null) {
                gridMain = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                gridMain = inflater.inflate(R.layout.franshing_cell_grid_3,parent,false)
            } else {
                gridMain = convertView
            }
            val linearLayout = gridMain as LinearLayout

            val elemet = linearLayout.getChildAt(0) as TextView
            elemet.text = collectionAgry[indexOfBlock].listInfoInvestor!![position]


            return gridMain
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = collectionAgry[indexOfBlock].listInfoInvestor!!.size
    }
}

