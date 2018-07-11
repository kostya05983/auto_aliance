package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.it_zoo.kostya05983.auto_aliance.Franchising.DataFranchisinGrid
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_franchising.*

class FranchisingActivity : AbstractNavigation() {
    private val collectionAgry: MutableList<DataFranchisinGrid> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_franchising)

        fillFirstParagraphsCollection()
        fillSecondParagraphsCollection()
        fillOfOurPoints()
        nav_view_franchising.setNavigationItemSelectedListener(this)
    }
    private fun fillCollection() {
        this.collectionAgry.add(0,
                DataFranchisinGrid(mutableListOf(
                        "\"Авто 99\"",
                        "Стоимость 99 000 рублей",
                        "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                        "Размещение на основном сайте и корпоративный чат 24\\7",
                        "Использование диспетчерской службы 8 - 800",
                        "GPS - трекинг транспорта",
                        "CRM - система индивидуально на город",
                        "Рекламные акции и материалы для продвижения",
                        "При выборе данной программы: ",
                        "Предоставляем доступ к сайту, почте и корп. чату;",
                        "Доступ к CRM-системе Вашего города;",
                        "Диспетчерская и ежедневные заказы;",
                        "Рекламные материалы;",
                        "Обучение и помощь на всех этапах ведения проекта",
                        " 99 000 рублей.",
                        " 1 500 рублей/автомобиль.",
                        "(Исключительно после обучения и запуска бизнеса)"
                ))
        )
        this.collectionAgry.add(1,
                DataFranchisinGrid(mutableListOf(
                        "\"Авто 149\"",
                        "Стоимость 149 000 рублей",
                        "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                        "Размещение на основном сайте и корпоративный чат 24\\7",
                        "Использование диспетчерской службы 8 - 800",
                        "GPS - трекинг транспорта",
                        "Доступ к CRM вашего города",
                        "Рекламные акции и материалы для продвижения",
                        "Офис в фирменном стиле",
                        "Программа \"Авто+1\"",
                        "1 автомобиль сразу",
                        "При выборе данной программы: ",
                        "Регистрируем ваше предприятие;",
                        "Подготавливаем офис к открытию;",
                        "Занимаетесь сбором необходимой информации;",
                        "Знакомство с лизингом и программой \"Авто+1\";",
                        "Обучение и помощь на всех этапах ведения проекта",
                        " 149 000 рублей.",
                        " 1 500 рублей/автомобиль."
                ))
        )
        this.collectionAgry.add(2,
                DataFranchisinGrid(mutableListOf(
                        "\"Авто 249\"",
                        "Стоимость 249 000 рублей",
                        "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                        "Размещение на основном сайте и корпоративный чат 24\\7",
                        "Использование диспетчерской службы 8 - 800",
                        "GPS - трекинг транспорта",
                        "Доступ к CRM вашего города",
                        "Рекламные акции и материалы для продвижения",
                        "Офис в фирменном стиле",
                        "Программа \"Авто+1\"",
                        "1 автомобиль сразу",
                        " 249 000 рублей.",
                        " 1 500 рублей/автомобиль.",
                        "Ваша прибыль составит: не менее 150 000 рублей чистого дохода в месяц (к расчёту взято направление проката авто без дополнительных программ)"
                ))
        )
        this.collectionAgry.add(3,
                DataFranchisinGrid(mutableListOf(
                        "\"Инвестор\"",
                        "Индивидуальные условия инвестирования в прибыльное направление автопроката с фиксированной процентной ставкой.",
                        "Обеспечение инвестирования имуществом на весь срок договора.",
                        "Сумма инвестирования от 2илн. рублей.",
                        "Срок договора 12 месяцев с последующей пролонгацией."
                ))
        )

    }

    inner class FranshingAdapter1(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var gridMain: View
            var gridListElement: View
            if( convertView == null) {
                gridMain = View(mContext)
                gridListElement = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                gridMain = inflater.inflate(R.layout.franshing_cell_grid,parent,false)
                gridListElement = inflater.inflate(R.layout.fashing_cell_item_list, parent, false)

            } else {
                gridMain = convertView
            }
            val title_1 = gridMain.findViewById<TextView>(R.id.title_1);
            val subtitle_1 = gridMain.findViewById<TextView>(R.id.title_1);



            return gridMain
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsSecondGrid.size
    }
    inner class FranshingAdapter2(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var grid: View
            if( convertView == null) {
                grid = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                grid = inflater.inflate(R.layout.franshing_cell_grid_2,parent,false)
            } else {
                grid = convertView
            }

            return grid
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsSecondGrid.size
    }
    inner class FranshingAdapter3(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var grid: View
            if( convertView == null) {
                grid = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                grid = inflater.inflate(R.layout.franshing_cell_grid_3,parent,false)
            } else {
                grid = convertView
            }

            val title_1 = grid.findViewById<TextView>(R.id.grid_second_image_part)
            imageView.setImageResource(mThumbIdsSecondGrid[position].id)

            val nameTextView = grid.findViewById<TextView>(R.id.grid_second_name_car)
            nameTextView.text = mThumbIdsSecondGrid[position].name

            val priceTextView = grid.findViewById<TextView>(R.id.grid_second_price_car)
            priceTextView.text = String.format("Цена: %s руб/ч  (до 6 ч.) \n%s руб/ч (свыше 6 ч.)",mThumbIdsSecondGrid[position].priceToSix,mThumbIdsSecondGrid[position].priceAfterSix.toString())

            return grid
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsSecondGrid.size
    }
    inner class FranshingAdapterListElement(private val mContext: Context): BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var grid: View
            if( convertView == null) {
                grid = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                grid = inflater.inflate(R.layout.fashing_cell_item_list,parent,false)
            } else {
                grid = convertView
            }

            val text = grid.findViewById<TextView>(R.id.item_section_ui)
            text.text = collectionfirstParagraphs[position];

            return grid
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = collectionfirstParagraphs.size
    }
}
